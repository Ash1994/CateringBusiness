package com.catering.in.CateringBusinessAuth.exceptionhandling.exceptions;


public class OauthResourceNotFoundException extends RuntimeException {

    public OauthResourceNotFoundException(String resource, String id) {
        super("Could not find " + resource + " with id : " + id);
    }

    public OauthResourceNotFoundException(String message) {
        super("Resource Not Found: " + message);
    }

}
