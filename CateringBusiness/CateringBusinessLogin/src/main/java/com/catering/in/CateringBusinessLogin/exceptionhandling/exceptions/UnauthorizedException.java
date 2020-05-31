package com.catering.in.CateringBusinessLogin.exceptionhandling.exceptions;


public class UnauthorizedException extends RuntimeException {

    public UnauthorizedException(String resource, String action) {
        super("Not allowed activity "+ action + " on resource " + resource);
    }

}
