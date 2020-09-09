package com.prabhu.userservice.exceptions;

/**
 * @project customer-service
 * @authoer Prabhu Madipalli
 */


public class UserNotFound extends RuntimeException {

    public UserNotFound(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }

}
