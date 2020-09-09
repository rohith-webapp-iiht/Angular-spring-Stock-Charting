package com.prabhu.userservice.shared;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

/**
 * This belongs to user-service
 *
 * @author Prabhu Madipalli
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {


    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String userId;
    private String encryptedPassword;

    //From here all are metadata

    private String accessType;
    private String email;
    private String mobileNumber;
    private boolean confirmed;
}
