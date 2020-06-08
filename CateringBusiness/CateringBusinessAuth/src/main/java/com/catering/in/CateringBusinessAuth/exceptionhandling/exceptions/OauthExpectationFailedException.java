package com.catering.in.CateringBusinessAuth.exceptionhandling.exceptions;


public class OauthExpectationFailedException extends RuntimeException {

    public OauthExpectationFailedException(String message) {
        super("Expectation failed. " + message);
    }

}
