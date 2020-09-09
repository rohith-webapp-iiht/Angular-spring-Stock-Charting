package com.prabhu.userservice.ui.model;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
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
public class UserCreationRequestModel {

    @Pattern(regexp = "^[A-Za-z0-9]*$", message = "Should consist only alphabets and numbers")
    @Size(min = 3, max = 25, message = "Size must be smaller than 26 and bigger than 2 characters")
    @NotNull(message = "User name shouldn't be null")
    private String username;

    @NotNull(message = "First name shouldn't be null")
    private String firstName;

    @NotNull(message = "Last name shouldn't be null")
    private String lastName;

    @Size(min = 8, message = "Minimum length for password is 8 characters")
    @NotNull(message = "Password shouldn' be null")
    private String password;


    //From here all are metadata

    @NotNull(message = "Choose one of the access")
    private String accessType;

    @Email(message = "Not a vaild email id")
    @NotNull(message = "Password should be null")
    private String email;

    @Pattern(regexp = "(^$|[0-9]{10})", message = "Should be a valid 10 digit mobile number")
    @Digits(integer = 10, fraction = 0)
    private String mobileNumber;

    private boolean confirmed;
}
