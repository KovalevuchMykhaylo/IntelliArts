package com.testproblem.kovalevuch.service.mainMenuComponents;

import com.testproblem.kovalevuch.entity.Expenses;
import com.testproblem.kovalevuch.enums.Pln;
import com.testproblem.kovalevuch.exceptions.ApiException;
import com.testproblem.kovalevuch.exceptions.WrongCommandFormatException;
import com.testproblem.kovalevuch.service.ExpensesService;
import com.testproblem.kovalevuch.utils.ConsoleMessagePrinters;
import com.testproblem.kovalevuch.utils.Parsers;
import com.testproblem.kovalevuch.utils.UrlSendGetRequest;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Component
public class TotalCommand {

    private ExpensesService expensesService;

    @Value("${fixerio.latest.request}")
    private String latestRequest;

    @Value("${fixerio.api.key}")
    private String apiKey;

    @Autowired
    public TotalCommand(ExpensesService expensesService) {
        this.expensesService = expensesService;
    }

    public void getTotalPrice(String fullInput) throws ApiException, WrongCommandFormatException {
        String[] parseInput = fullInput.trim().split(" ");
        if (parseInput.length < 2) {
            throw new WrongCommandFormatException("Wrong PLN input!!!");
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

    private void totalPrice(Pln pln, JSONObject rates, List<Expenses> expenses) throws JSONException {
        BigDecimal total = new BigDecimal(0);
        for (Expenses e : expenses)
            if (!e.getPln().equals(pln)) {
                BigDecimal euroPrice = e.getPrice().divide(rates.getBigDecimal(e.getPln().name()), 4, RoundingMode.CEILING);
                BigDecimal convertedPrice = euroPrice.multiply(rates.getBigDecimal(pln.name()));
                total = total.add(convertedPrice);
            } else {
                total = total.add(e.getPrice());
            }
        ConsoleMessagePrinters.successPrinter(total.setScale(2, RoundingMode.CEILING).toString());
    }

    private void jsonResponseParser(Pln pln) throws JSONException {
        List<Expenses> expenses = expensesService.findAll();
        if (expenses.isEmpty()) {
            ConsoleMessagePrinters.successPrinter("You don't have any expenses yet!!!");
            return;
        }
        JSONObject jsonObject = new JSONObject(UrlSendGetRequest.createUrl(latestRequest + apiKey));
        JSONObject object = new JSONObject(jsonObject.getJSONObject("rates").toString());
        totalPrice(pln, object, expenses);
    }
}
