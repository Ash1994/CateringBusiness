package com.catering.in.CateringBusinessLogin.exceptionhandling.exceptions;


public class ExpectationFailedException extends RuntimeException {

    public ExpectationFailedException(String message) {
        super("Expectation failed. " + message);
    }

}
