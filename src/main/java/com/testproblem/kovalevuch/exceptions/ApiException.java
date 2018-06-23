package com.testproblem.kovalevuch.exceptions;

public class ApiException extends Exception{

    private final String message = "Trouble with API please contact support!!!";

    @Override
    public String getMessage() {
        return message;
    }
}
