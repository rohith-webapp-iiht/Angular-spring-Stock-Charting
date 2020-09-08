package com.prabhu.userservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * This belongs to user-service
 *
 * @author Prabhu Madipalli
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCreationRequestModel {

    @Pattern(regexp = "^[A-Za-z]*$")
    @Size(max = 25, min = 3)
    @NotNull
    @Column(nullable = false, unique = true)
    private String username;

    /**
     * The users first name
     */
    @Column(nullable = false)
    private String firstName;

    /**
     * The user's last name.
     */
    @Column(nullable = false)
    private String lastName;

    /**
     * This is for internal identification. Not for login. not for contacting. Not taken from user. User doesn't know
     * this. We generate this while creating the User
     */
    @Column(nullable = false)
    private String UserId;

    /**
     * Password encrypted by Spring Security
     */
    private String encryptedPassword;


    //From here all are metadata
    /**
     * This is to specify which access the user possess. Not implementing yet.
     */
    private String accessType;


//    @Email
    /**
     * This is only for verification and contacting not for user identification. Can be used for password retrieval.
     */
    @Column(nullable = false, unique = true)
    private String email;

//    @Pattern(regexp = "(^$|[0-9]{10})")
//    @Digits(integer = 10, fraction = 0)
    /**
     * This is also similar to Email Id. But can be null
     */
    @Column(unique = true, nullable = true)
    private String mobileNumber;

    /**
     * Whether the email is verified or not
     */
    private boolean Confirmed;
}
