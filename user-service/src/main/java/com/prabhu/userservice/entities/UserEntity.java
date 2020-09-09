package com.prabhu.userservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * This belongs to user-service
 *
 * @author Prabhu Madipalli
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

    /**
     * This is for SQL Identification
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private int id;


    /**
     * This is for user to identify himself
     * This is used for logging in and the user can choose what it can be.
     */
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
    private String userId;

    /**
     * Password encrypted by Spring Security
     */
    private String encryptedPassword;


    //From here all are metadata
    /**
     * This is to specify which access the user possess. Not implementing yet.
     */
    private String accessType;


    /**
     * This is only for verification and contacting not for user identification. Can be used for password retrieval.
     */
    @Column(nullable = false, unique = true)
    private String email;

    /**
     * This is also similar to Email Id. But can be null
     */
    @Column(unique = true, nullable = true)
    private String mobileNumber;

    /**
     * Whether the email is verified or not
     */
    private boolean confirmed;
}
