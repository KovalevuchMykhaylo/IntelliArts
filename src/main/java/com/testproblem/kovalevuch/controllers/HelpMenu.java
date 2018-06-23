package com.testproblem.kovalevuch.controllers;

import com.testproblem.kovalevuch.constants.Constants;
import com.testproblem.kovalevuch.enums.HelpMenuCommands;
import com.testproblem.kovalevuch.utils.ConsoleMessagePrinters;
import com.testproblem.kovalevuch.utils.Parsers;

import java.util.Scanner;

public interface HelpMenu {

    static void helpMenu() {

        ConsoleMessagePrinters.successPrinter(Constants.HelpMenu.HELP);

        while (true) {
            System.out.println("Enter PLN to show available PLN");
            System.out.println("Enter RETURN to return to main menu");

            Scanner sc = new Scanner(System.in);

            HelpMenuCommands commands = Parsers.stringToHELPMenuCommands(sc.next());

            switch (commands) {
                case PLN:
                    ConsoleMessagePrinters.successPrinter(Constants.HelpMenu.PLN_NAMES);
                    break;
                case WRONG_HELP_COMMAND:
                    ConsoleMessagePrinters.errorPrinter("Wrong command!!!");
                    break;
                case RETURN:
                    return;
            }
        }
    }
}