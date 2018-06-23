package com.testproblem.kovalevuch.service.serviceImplementation;

import com.testproblem.kovalevuch.exceptions.WrongCommandFormatException;
import com.testproblem.kovalevuch.service.DayExpensesService;
import com.testproblem.kovalevuch.service.MainMenuService;
import com.testproblem.kovalevuch.service.mainMenuComponents.AddCommand;
import com.testproblem.kovalevuch.service.mainMenuComponents.ClearCommand;
import com.testproblem.kovalevuch.service.mainMenuComponents.TotalCommand;
import com.testproblem.kovalevuch.utils.Parsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainMenuServiceImplementation implements MainMenuService {

    private AddCommand addCommand;

    private ClearCommand clearCommand;

    private TotalCommand totalCommand;

    private DayExpensesService dayExpensesService;

    @Autowired
    public MainMenuServiceImplementation(AddCommand addCommand, ClearCommand clearCommand, TotalCommand totalCommand,
                                         DayExpensesService dayExpensesService) {
        this.addCommand = addCommand;
        this.clearCommand = clearCommand;
        this.totalCommand = totalCommand;
        this.dayExpensesService = dayExpensesService;
    }

    @Override
    public void addCommand(String fullInput) {
        try {
            addCommand.createExpenses(fullInput);
        } catch (WrongCommandFormatException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void clearCommand(String fullInput) {
        try {
            clearCommand.clearCommand(fullInput);
        } catch (WrongCommandFormatException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void totalCommand(String fullInput) {
        totalCommand.getTotalPrice(fullInput);
    }

    @Override
    public void listCommand() {
        Parsers.printer(dayExpensesService.findAll());
    }
}
