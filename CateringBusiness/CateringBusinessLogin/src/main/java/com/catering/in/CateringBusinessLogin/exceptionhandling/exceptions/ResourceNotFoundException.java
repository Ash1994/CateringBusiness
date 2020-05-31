package com.catering.in.CateringBusinessLogin.exceptionhandling.exceptions;


public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String resource, String id) {
        super("Could not find " + resource + " with id : " + id);
    }

    public ResourceNotFoundException(String message) {
        super("Resource Not Found: " + message);
    }

}
