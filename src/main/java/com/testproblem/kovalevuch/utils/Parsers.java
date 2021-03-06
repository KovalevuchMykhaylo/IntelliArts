package com.testproblem.kovalevuch.utils;

import com.testproblem.kovalevuch.constants.Constants;
import com.testproblem.kovalevuch.enums.HelpMenuCommands;
import com.testproblem.kovalevuch.enums.MainMenuCommands;
import com.testproblem.kovalevuch.enums.Pln;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

import static com.testproblem.kovalevuch.constants.Constants.DATE_REGX;
import static com.testproblem.kovalevuch.enums.HelpMenuCommands.WRONG_HELP_COMMAND;
import static com.testproblem.kovalevuch.enums.MainMenuCommands.WRONG_COMMAND;

public interface Parsers {

    static BigDecimal priceParser(String price) {
        if (price != null) {
            if (price.contains(",")) {
                price = price.replace(",", ".");
            }
            Pattern priceRegWithDecimal = Pattern.compile((Constants.BIG_DECIMAL_WITH_DOT));
            Pattern priceReg = Pattern.compile(Constants.BIG_DECIMAL_WITHOUT_DOT);
            if (priceRegWithDecimal.matcher(price).matches() | priceReg.matcher(price).matches()) {
                return new BigDecimal(price);
            }
        }
        return null;
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

    static HelpMenuCommands stringToHELPMenuCommands(String helpMenuCommands) {
        if (helpMenuCommands != null) {
            HelpMenuCommands[] enums = HelpMenuCommands.values();
            for (HelpMenuCommands anEnum : enums)
                if (anEnum.name().equalsIgnoreCase(helpMenuCommands)) {
                    return anEnum;
                }
        }
        return WRONG_HELP_COMMAND;
    }
}
