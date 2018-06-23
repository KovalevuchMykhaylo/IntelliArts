package com.testproblem.kovalevuch.exceptions;

public class ApiException extends Exception{

    private final String message = "Trouble with API please contact support, or call +380638601886!!!";

    @Override
    public String getMessage() {
        return message;
    }
}
