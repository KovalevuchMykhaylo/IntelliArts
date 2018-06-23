package com.testproblem.kovalevuch.controllers;

import com.testproblem.kovalevuch.enums.MainMenuCommands;
import com.testproblem.kovalevuch.service.DayExpensesService;
import com.testproblem.kovalevuch.service.MainMenuService;
import com.testproblem.kovalevuch.service.mainMenuComponents.AddCommand;
import com.testproblem.kovalevuch.service.mainMenuComponents.ClearCommand;
import com.testproblem.kovalevuch.utils.ConsoleMessagePrinters;
import com.testproblem.kovalevuch.utils.Parsers;
import com.testproblem.kovalevuch.service.mainMenuComponents.TotalCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

import static com.testproblem.kovalevuch.constants.Constants.MAIN_MENU;
import static com.testproblem.kovalevuch.constants.Constants.WELCOME_MESSAGE;

@Component
public class MainMenu {

    private MainMenuService mainMenuService;

    @Autowired
    public MainMenu(MainMenuService mainMenuService) {
        this.mainMenuService = mainMenuService;
    }

    public void menu() {
        System.out.println(WELCOME_MESSAGE);
        while (true) {
            Scanner sc = new Scanner(System.in);

            System.out.println(MAIN_MENU);

            String fullInput = sc.nextLine();

            MainMenuCommands command = Parsers.commandParser(fullInput.trim().split(" ")[0]);

            switch (command) {
                case ADD:
                    mainMenuService.addCommand(fullInput);
                    break;
                case LIST:
                    mainMenuService.listCommand();
                    break;
                case CLEAR:
                    mainMenuService.clearCommand(fullInput);
                    break;
                case TOTAL:
                    mainMenuService.totalCommand(fullInput);
                    break;
                case EXIT:
                    sc.close();
                    return;
                case WRONG_COMMAND:
                    ConsoleMessagePrinters.errorPrinter("Wrong command!!!");
                    break;
                default:
                    break;
            }
        }
    }
}
