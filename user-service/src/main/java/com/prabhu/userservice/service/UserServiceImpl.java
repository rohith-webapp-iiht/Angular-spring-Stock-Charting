package com.prabhu.userservice.service;

import com.prabhu.userservice.entities.UserEntity;
import com.prabhu.userservice.exceptions.AccountActivationException;
import com.prabhu.userservice.exceptions.UserNotFound;
import com.prabhu.userservice.repo.UserRepo;
import com.prabhu.userservice.shared.UserDto;
import com.prabhu.userservice.ui.model.UserResponseModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * This belongs to user-service
 *
 * @author Prabhu Madipalli
 */

@Service
public class UserServiceImpl implements UserService {
    private final UserRepo repo;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final Environment env;

    private final ModelMapper mapper;

    private final Type listType;

    @Autowired
    public UserServiceImpl(UserRepo repo, ModelMapper mapper,
                           Environment env, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.listType = new TypeToken<List<UserResponseModel>>() {
        }.getType();
        this.mapper = mapper;
        this.repo = repo;
        this.env = env;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> byUsername = this.repo.findUserEntityByUsername(username);
        if (byUsername.isEmpty()) {
            throw new UsernameNotFoundException("No user found with the username " + username);
        }
        UserEntity userEntity = byUsername.get();

        return new User(userEntity.getEmail(), userEntity.getEncryptedPassword(),
                true, true, true, true,
                new ArrayList<>());

    }

    @Override
    public UserDto getUserDetailsByUserId(String userId) {
        Optional<UserEntity> userEntityByUserId = this.repo.findUserEntityByUserId(userId);
        if(userEntityByUserId.isEmpty()){
            throw new UsernameNotFoundException("User not found");
        }
        return mapper.map(userEntityByUserId.get(), UserDto.class);
    }

    @Override
    public UserDto createUser(UserDto userDetails) {
        userDetails.setUserId(UUID.randomUUID().toString());
        userDetails.setEncryptedPassword(bCryptPasswordEncoder.encode(userDetails.getPassword()));

        UserEntity userEntity = mapper.map(userDetails, UserEntity.class);

        userEntity = repo.save(userEntity);

        UserDto ret = mapper.map(userEntity, UserDto.class);

        return ret;

    }

    @Override
    public UserDto getUserDetailsByUsername(String username) {
        Optional<UserEntity> byUsername = repo.findUserEntityByUsername(username);

        if (byUsername.isEmpty()) {
            throw new UserNotFound("No user found with this username");
        }

        return mapper.map(byUsername.get(), UserDto.class);
    }

//Until here compulsory functions













    @Override
    public Optional<UserResponseModel> findById(@NotNull int id) {
        Optional<UserEntity> byId = repo.findById(id);
        if (byId.isEmpty()) {
            return Optional.empty();
        }
        UserResponseModel userResponseModel = this.mapper.map(byId.get(), UserResponseModel.class);
        return Optional.of(userResponseModel);
    }

    @Override
    public Iterable<UserResponseModel> getAllUsers() {
        return this.mapper.<List<UserResponseModel>>map(repo.findAll(), this.listType);
    }

    @Override
    public Iterable<UserResponseModel> getByName(String name) {
        List<UserEntity> foundUserEntities =
                this.repo.findUserEntitiesByFirstNameContainingOrLastNameContaining(name, name);
        return this.mapper.map(foundUserEntities, listType);
    }

    @Override
    public Optional<UserResponseModel> findByEmailId(@Email String email) {
        Optional<UserEntity> userByEmail = repo.findUserEntityByEmail(email);
        if (userByEmail.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(this.mapper.map(userByEmail.get(), UserResponseModel.class));
    }

    @Override
    public UserEntity saveUser(UserEntity userEntity) {
        return this.repo.save(userEntity);
    }

    @Override
    public void activate(String username, String email, int userId) throws AccountActivationException {
        Optional<UserResponseModel> user = this.findById(userId);
        if (user.isEmpty()) {
            throw new AccountActivationException("Account with that userId doesnt exist");
        }
        if (user.get().getEmail().equals(email) && user.get().getUsername().equals(username)) {
            repo.setCondirmedTrue(userId);
        } else {
            throw new AccountActivationException("All details didn't match");
        }
    }


}
