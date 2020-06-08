package com.catering.in.CateringBusinessAuth.exceptionhandling.exceptions;


public class OauthUnauthorizedException extends RuntimeException {

    public OauthUnauthorizedException(String resource, String action) {
        super("Not allowed activity "+ action + " on resource " + resource);
    }

}
