package com.testproblem.kovalevuch;

import com.testproblem.kovalevuch.entity.DayExpenses;
import com.testproblem.kovalevuch.entity.Expenses;
import com.testproblem.kovalevuch.enums.MainMenuCommands;
import com.testproblem.kovalevuch.enums.Pln;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

//import testProblem.configurations.DataBaseConfig;

public class Main {

        public static void main(String[] args) {

            System.out.println("\033[31;1mHello\033[0m, \033[32;1;2mworld!\033[0m");
            System.out.println("\033[31mRed\033[32m, Green\033[33m, Yellow\033[34m, Blue\033[0m");
            System.out.println("\033[31mRed\033[0m");
            System.out.println("Hello");

            String s = "http://data.fixer.io/api/latest?access_key=6e7404fdb0cf293504341a4d7380a16d&base=USD&symbols=GBP,JPY,EUR";
            String d = "http://data.fixer.io/api/latest?access_key=6e7404fdb0cf293504341a4d7380a16d&base=USD";
//            http://data.fixer.io/api/lates?access_key=6e7404fdb0cf293504341a4d7380a16d&base=USD&symbols=GBP,JPY,EUR
//            http://data.fixer.io/api/2013-12-24?access_key=6e7404fdb0cf293504341a4d7380a16d&base=USD&symbols=GBP,JPY,EUR
    }


    public static BigDecimal priceParser(String price) {
        if (price != null) {
            if (price.contains(",")) {
                price = price.replace(",", ".");
            }
            Pattern priceRegWithDecimal = Pattern.compile(("^([0-9]{1,17}\\.[0-9]{1,2})$"));
            Pattern priceReg = Pattern.compile("^([0-9]{1,17})$");
            if (priceReg.matcher(price).matches() | priceRegWithDecimal.matcher(price).matches()) {
                return new BigDecimal(price).setScale(2);
            }
        }
        return null;
    }

    public static void printer(DayExpenses dayExpenses) {
        System.out.println(dayExpenses.getDate());
        dayExpenses.getProducts().forEach(System.out::println);
    }

    private static Pln stringToPln(String pln) {
        if (pln != null) {
            Pln[] enums = Pln.values();
            for (Pln anEnum : enums)
                if (anEnum.name().equalsIgnoreCase(pln)) {
                    return anEnum;
                }
        }
        return null;
    }

    private static MainMenuCommands stringTomainMenuCommands(String mainMenuCommands) {
        if (mainMenuCommands != null) {
            MainMenuCommands[] enums = MainMenuCommands.values();
            for (MainMenuCommands anEnum : enums)
                if (anEnum.name().equalsIgnoreCase(mainMenuCommands)) {
                    return anEnum;
                }
        }
        return null;
    }

    private static String comandParser(String input) {
//        String commandParser = "add 2017-04-25 12 USD Jogurt";
//        System.out.println(commandParser.trim().split(" ")[0]);
        return input.trim().split(" ")[0];
    }

    private static LocalDate dateParser(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");

//        String date = "2016-08-16";

        Pattern DATE_PATTERN = Pattern.compile("^((19|2[0-9])[0-9]{2})-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$");
        if (!DATE_PATTERN.matcher(date).matches()) {
            System.out.println("Wrong date format");
            return null;
        }

        //convert String to LocalDate
        return LocalDate.parse(date, formatter);
    }
}
