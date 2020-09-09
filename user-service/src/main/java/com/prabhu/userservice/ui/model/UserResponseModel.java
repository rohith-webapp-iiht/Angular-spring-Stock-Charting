package com.prabhu.userservice.ui.model;

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
public class UserResponseModel {

    private String username;

    private String firstName;

    private String lastName;

    private String userId;

    //From here rest are Metadata

    private String accessType;

    private String email;

    private String mobileNumber;

    private boolean confirmed;
}
