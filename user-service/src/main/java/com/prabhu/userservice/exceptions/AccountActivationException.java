package com.prabhu.userservice.exceptions;

/**
 * @project customer-service
 * @authoer Prabhu Madipalli
 */


public class AccountActivationException extends RuntimeException {

    public AccountActivationException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }

}
