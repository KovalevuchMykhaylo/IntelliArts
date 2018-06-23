package com.testproblem.kovalevuch.service.mainMenuComponents;

import com.testproblem.kovalevuch.exceptions.WrongCommandFormatException;
import com.testproblem.kovalevuch.service.DayExpensesService;
import com.testproblem.kovalevuch.utils.ConsoleMessagePrinters;
import com.testproblem.kovalevuch.utils.Parsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ClearCommand {

    private DayExpensesService dayExpensesService;

    @Autowired
    public ClearCommand(DayExpensesService dayExpensesService) {
        this.dayExpensesService = dayExpensesService;
    }

    public void clearCommand(String fullInput) throws WrongCommandFormatException {
        String[] arrayFullInout = fullInput.trim().split(" ");
        if (arrayFullInout.length < 2) {
            throw new WrongCommandFormatException("Please enter correct add command like: clear 2017-04-25!!!");
        }
        LocalDate date = Parsers.dateParser(arrayFullInout[1]);
        if (date == null) {
            ConsoleMessagePrinters.errorPrinter("Wrong date input!!!");
        }
        dayExpensesService.delete(date);
    }
}
