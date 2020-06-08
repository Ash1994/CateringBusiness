package com.catering.in.CateringBusinessAuth.exceptionhandling.handlers;

import com.catering.in.CateringBusinessAuth.exceptionhandling.exceptions.OauthExpectationFailedException;
import com.catering.in.CateringBusinessAuth.exceptionhandling.exceptions.OauthResourceNotFoundException;
import com.catering.in.CateringBusinessAuth.exceptionhandling.exceptions.OauthUnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class OauthExceptionHandlerAdvice
{

    private static final Map<Class, HttpStatus> exceptionStatusMap;

    static {
        exceptionStatusMap = new HashMap<>();
        exceptionStatusMap.put(OauthResourceNotFoundException.class, HttpStatus.NOT_FOUND);
        exceptionStatusMap.put(OauthExpectationFailedException.class, HttpStatus.EXPECTATION_FAILED);
        exceptionStatusMap.put(OauthUnauthorizedException.class, HttpStatus.UNAUTHORIZED);
    }

    // We do not want any internal details messages of system to go out to
    // client services.
    // So we overriding internal details messages with - INTERNAL SERVER ERROR.
    @ResponseBody
    @ExceptionHandler(Throwable.class)
    ResponseEntity<String> handle(Throwable ex) {
        HttpStatus status = exceptionStatusMap.get(ex.getClass());
        String message = ex.getMessage();
        if (status == null || status.equals(HttpStatus.INTERNAL_SERVER_ERROR)) {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
            message = "INTERNAL SERVER ERROR";
        }
        return new ResponseEntity<>(message, status);
    }

}
