package com.prabhu.userservice.service;

import java.util.Optional;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.prabhu.userservice.entities.UserEntity;
import com.prabhu.userservice.exceptions.AccountActivationException;
import com.prabhu.userservice.shared.UserDto;
import com.prabhu.userservice.ui.model.UserResponseModel;

/**
 * This belongs to user-service
 *
 * @author Prabhu Madipalli
 */

public interface UserService extends UserDetailsService {



    UserDto createUser(UserDto userDto);

    UserDto getUserDetailsByUsername(String username);

    UserDto getUserDetailsByUserId(String userId);

    //Until Here compulsory functions

    Optional<UserResponseModel> findById(@NotNull int id);

    public Iterable<UserResponseModel> getAllUsers();

    Iterable<UserResponseModel> getByName(String name);

    Optional<UserResponseModel> findByEmailId(@Email String email);

    UserEntity saveUser(UserEntity userEntity);

    void activate(String username, String email, int userId) throws AccountActivationException;

}
