package com.testproblem.kovalevuch.utils;

import com.testproblem.kovalevuch.entity.DayExpenses;

import java.util.List;

public interface ConsoleMessagePrinters {

    static void errorPrinter(String errorMessage) {
        System.out.println("\033[31m" + errorMessage + "\033[0m");
    }

    static void successPrinter(String success) {
        System.out.println("\033[34m" + success + "\033[0m");
    }

    static void listPrinter(List<DayExpenses> dayExpenses) {
        dayExpenses.forEach(e -> {
            System.out.println(e.getDate());
            e.getProducts().forEach(System.out::println);
        });
    }
}
