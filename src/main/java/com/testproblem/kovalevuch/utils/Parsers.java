package com.testproblem.kovalevuch.utils;

import com.testproblem.kovalevuch.constants.Constants;
import com.testproblem.kovalevuch.entity.DayExpenses;
import com.testproblem.kovalevuch.enums.MainMenuCommands;
import com.testproblem.kovalevuch.enums.Pln;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.regex.Pattern;

import static com.testproblem.kovalevuch.constants.Constants.DATE_REGX;
import static com.testproblem.kovalevuch.enums.MainMenuCommands.WRONG_COMMAND;

public interface Parsers {

    static BigDecimal priceParser(String price) {
        if (price != null) {
            if (price.contains(",")) {
                price = price.replace(",", ".");
            }
            Pattern priceRegWithDecimal = Pattern.compile((Constants.BIG_DECIMAL_WITH_DOT));
            Pattern priceReg = Pattern.compile(Constants.BIG_DECIMAL_WITHOUT_DOT);
            if (priceReg.matcher(price).matches() | priceRegWithDecimal.matcher(price).matches()) {
                return new BigDecimal(price).setScale(2);
            }
        }
        return null;
    }

    static void printer(List<DayExpenses> dayExpenses) {
        dayExpenses.forEach(e -> {
            System.out.println(e.getDate());
            e.getProducts().forEach(System.out::println);
        });
        System.out.println();
    }

    static Pln stringToPln(String pln) {
        if (pln != null) {
            Pln[] enums = Pln.values();
            for (Pln anEnum : enums)
                if (anEnum.name().equalsIgnoreCase(pln)) {
                    return anEnum;
                }
        }
        return null;
    }

    static MainMenuCommands stringToMainMenuCommands(String mainMenuCommands) {
        if (mainMenuCommands != null) {
            MainMenuCommands[] enums = MainMenuCommands.values();
            for (MainMenuCommands anEnum : enums)
                if (anEnum.name().equalsIgnoreCase(mainMenuCommands)) {
                    return anEnum;
                }
        }
        return WRONG_COMMAND;
    }

    static MainMenuCommands commandParser(String input) {
        return stringToMainMenuCommands(input);
    }

    static LocalDate dateParser(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
        Pattern DATE_PATTERN = Pattern.compile(DATE_REGX);
        if (!DATE_PATTERN.matcher(date).matches()) {
            return null;
        }
        return LocalDate.parse(date, formatter);
    }
}
