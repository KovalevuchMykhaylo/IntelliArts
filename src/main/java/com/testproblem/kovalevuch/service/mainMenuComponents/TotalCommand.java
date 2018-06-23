package com.testproblem.kovalevuch.service.mainMenuComponents;

import com.testproblem.kovalevuch.constants.Constants;
import com.testproblem.kovalevuch.entity.Expenses;
import com.testproblem.kovalevuch.enums.Pln;
import com.testproblem.kovalevuch.exceptions.ApiException;
import com.testproblem.kovalevuch.service.ExpensesService;
import com.testproblem.kovalevuch.utils.ConsoleMessagePrinters;
import com.testproblem.kovalevuch.utils.Parsers;
import com.testproblem.kovalevuch.utils.UrlSendGetRequest;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Component
public class TotalCommand {

    private ExpensesService expensesService;

    @Autowired
    public TotalCommand(ExpensesService expensesService) {
        this.expensesService = expensesService;
    }

    public void getTotalPrice(String fullInput) throws ApiException {

        String[] parseInput = fullInput.trim().split(" ");
        if (parseInput.length < 2) {
            ConsoleMessagePrinters.errorPrinter("Wrong PLN input!!!");
        }

        Pln pln = Parsers.stringToPln(fullInput.trim().split(" ")[1]);
        if (pln == null) {
            ConsoleMessagePrinters.errorPrinter("Wrong PLN input!!!");
            return;
        }
        try {
            jsonResponseParser(pln);
        } catch (Exception e) {
            throw new ApiException();
        }
    }

    private void totalPrice(Pln pln, JSONObject rates) {
        List<Expenses> expenses = expensesService.findAll();
        BigDecimal total = new BigDecimal(0);
        for (Expenses e : expenses)
            if (!e.getPln().equals(pln) && !e.getPln().equals(Pln.EUR)) {
                BigDecimal euroPrice = e.getPrice().multiply(BigDecimal.valueOf((Double) rates.get(pln.name())));
                total = total.add(euroPrice.multiply(BigDecimal.valueOf((Double) rates.get(pln.name()))));
            } else {
                total = total.add(e.getPrice());
            }
        ConsoleMessagePrinters.successPrinter(total.setScale(2, RoundingMode.CEILING).toString());
    }

    private void jsonResponseParser(Pln pln) {
        JSONObject jsonObject = new JSONObject(UrlSendGetRequest.createUrl(Constants.ApiConsts.LATEST_WITH_API_KEY));
        JSONObject object = new JSONObject(jsonObject.getJSONObject("rates").toString());
        totalPrice(pln, object);
    }
}
