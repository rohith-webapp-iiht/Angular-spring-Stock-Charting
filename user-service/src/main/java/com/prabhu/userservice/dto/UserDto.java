package com.prabhu.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * This belongs to user-service
 *
 * @author Prabhu Madipalli
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private int id;

    @NotNull
    private String username;

    private String firstName;

    private String lastName;

    private String accessType;

    private String email;

    private String mobileNumber;

    private boolean Confirmed;
}
