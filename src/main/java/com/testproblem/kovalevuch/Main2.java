package com.testproblem.kovalevuch;

import org.json.JSONObject;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main2 {

    public static void main(String[] args) {
        String responce = "{" +
                "\"success\"" + ": " + "true, " +
                "\"timestamp\"" + ": " + 1519296206 + ", " +
                "\"base\"" + ": " + "\"EUR\"" + "," +
                "\"date\"" + ": " + "\"2018-06-21\"" + ", " +
                "\"rates\"" + ": " + "{" +
                "\"AUD\"" + ": " + 1.566015 + ", " +
                "\"CAD\"" + ": " + 1.560132 + ", " +
                "\"CHF\"" + ": " + 1.154727 + ", " +
                "\"CNY\"" + ": " + 7.827874 + ", " +
                "\"GBP\"" + ": " + 0.882047 + ", " +
                "\"JPY\"" + ": " + 132.360679 + ", " +
                "\"USD\"" + ": " + 1.23396  + "}" + "}";
        System.out.println(responce);

        JSONObject jsonObject = new JSONObject(responce);
        System.out.println(jsonObject.get("rates"));
        JSONObject object = new JSONObject(jsonObject.getJSONObject("rates").toString());
        System.out.println(object.toString());
//        BigDecimal price = new BigDecimal(object.get("GBP").toString());
        BigDecimal price = BigDecimal.valueOf((Double) object.get("GBP"));
//        Double price = (Double) object.get("AUD");
        System.out.println(price);

        BigDecimal productPrice = new BigDecimal(100);

        productPrice = productPrice.multiply(price);

        System.out.println("Converted price is: " + productPrice);
        System.out.println("Converted price is: " + productPrice.setScale(2, RoundingMode.CEILING));
    }
}
