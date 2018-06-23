package com.testproblem.kovalevuch.utils;

public interface ConsoleMessagePrinters {

    static void errorPrinter(String errorMessage){
        System.out.println("\033[31m" + errorMessage + "\033[0m");
    }

    static void successPrinter(String success){
        System.out.println("\033[34m" + success + "\033[0m");
    }
}
