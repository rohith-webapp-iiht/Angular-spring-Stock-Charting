package com.prabhu.userservice.exceptions.handlers;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.prabhu.userservice.exceptions.AccountActivationException;
import com.prabhu.userservice.exceptions.UserNotFound;

/**
 * @project customer-service
 * @authoer Prabhu Madipalli
 */

@ControllerAdvice
public class NoUserHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handlingResponse(UserNotFound exception) {

        return new ResponseEntity<>(
                new ErrorResponse(
                        exception.getMessage(),
                        HttpStatus.NOT_FOUND.value(),
                        new Date()
                ),
                HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<ErrorResponse> handlingReponse2(AccountActivationException exception) {
        return new ResponseEntity<>(new ErrorResponse(
                exception.getMessage(),
                HttpStatus.NOT_ACCEPTABLE.value(),
                new Date()
        ), HttpStatus.NOT_ACCEPTABLE);
    }

}
