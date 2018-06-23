package com.testproblem.kovalevuch.service.mainMenuComponents;

import com.testproblem.kovalevuch.entity.DayExpenses;
import com.testproblem.kovalevuch.entity.Expenses;
import com.testproblem.kovalevuch.enums.Pln;
import com.testproblem.kovalevuch.exceptions.WrongCommandFormatException;
import com.testproblem.kovalevuch.service.DayExpensesService;
import com.testproblem.kovalevuch.service.ExpensesService;
import com.testproblem.kovalevuch.utils.ConsoleMessagePrinters;
import com.testproblem.kovalevuch.utils.Parsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;

@Component
public class AddCommand {

    private DayExpensesService dayExpensesService;

    private ExpensesService expensesService;

    @Autowired
    public AddCommand(DayExpensesService dayExpensesService, ExpensesService expensesService) {
        this.dayExpensesService = dayExpensesService;
        this.expensesService = expensesService;
    }

    public void createExpenses(String fullInput) throws WrongCommandFormatException {
        String[] arrayFullInout = fullInput.split(" ");
        if (arrayFullInout.length < 4) {
            throw new WrongCommandFormatException("Please enter correct add command like: add 2017-04-25 12 USD Jogurt!!!");
        }
        LocalDate localDate = Parsers.dateParser(arrayFullInout[1]);
        String productName = productName(arrayFullInout[4]);
        BigDecimal price = Parsers.priceParser(arrayFullInout[2]);
        Pln pln = Parsers.stringToPln(arrayFullInout[3]);
        String errors = errorsMessage(localDate, productName, price, pln);
        if (errors != null) {
            ConsoleMessagePrinters.errorPrinter(errors);
            return;
        }
        DayExpenses dayExpenses = dayExpensesService.findOneByDate(localDate);
        Expenses expenses = new Expenses(productName, price, pln);
        if (dayExpenses == null) {
            dayExpenses = new DayExpenses();
            dayExpenses.setDate(localDate);
            dayExpenses.setProducts(Collections.singletonList(expenses));
            expenses.setDayExpenses(dayExpenses);
            dayExpensesService.save(dayExpenses);
        } else {
            expenses.setDayExpenses(dayExpenses);
            expensesService.save(expenses);
        }
    }

    private String productName(String name) {
        if (name.length() > 254) {
            return null;
        }
        return name;
    }

    private String errorsMessage(LocalDate localDate, String productName, BigDecimal price, Pln pln) {
        if (productName == null | price == null | pln == null | localDate == null) {
            StringBuffer sb = new StringBuffer();
            if(localDate == null) sb.append("Wrong date format!!!");
            if (productName == null) sb.append("To long product name!!! ");
            if (price == null) sb.append("Wrong price format!!! ");
            if (pln == null) sb.append("Wrong pln!!!");
            return sb.toString();
        }
        return null;
    }
}
