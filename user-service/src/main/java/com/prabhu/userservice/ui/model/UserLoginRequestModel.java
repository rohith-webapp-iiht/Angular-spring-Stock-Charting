package com.prabhu.userservice.ui.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This belongs to user-service
 *
 * @author Prabhu Madipalli
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginRequestModel {

    @Pattern(regexp = "^[A-Za-z]*$")
    @Size(max = 100, min = 3)
    @NotNull
    private String username;

    @Size(min = 8)
    @NotNull
    private String password;
}
