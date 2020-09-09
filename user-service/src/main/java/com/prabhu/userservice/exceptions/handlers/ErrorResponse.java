package com.prabhu.userservice.exceptions.handlers;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @project customer-service
 * @authoer Prabhu Madipalli
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {
    private String message;
    private int statusCode;
    private Date exceptionTime;
}
