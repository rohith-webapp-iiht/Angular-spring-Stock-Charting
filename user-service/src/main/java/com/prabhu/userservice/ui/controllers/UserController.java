package com.prabhu.userservice.ui.controllers;

import com.prabhu.userservice.service.UserService;
import com.prabhu.userservice.shared.UserDto;
import com.prabhu.userservice.ui.model.UserCreationRequestModel;
import com.prabhu.userservice.ui.model.UserResponseModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * This belongs to user-service
 *
 * @author Prabhu Madipalli
 */

@RestController
@RequestMapping(value = "/api/users")
public class UserController {


    @Autowired
    private Environment env;

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/status/check")
    public String status()
    {
        return "Working on port " + env.getProperty("local.server.port") + ", with token = " + env.getProperty("token.secret");
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<UserResponseModel>> getAll() {

        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.ACCEPTED);
    }

    @PostMapping("/new_user")
    public ResponseEntity<UserResponseModel> createUser(@RequestBody UserCreationRequestModel userDetails)
    {
       UserDto userDto = modelMapper.map(userDetails, UserDto.class);

        UserDto createdUser = userService.createUser(userDto);

        UserResponseModel returnValue = modelMapper.map(createdUser, UserResponseModel.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(returnValue);
    }

    @GetMapping(value="/{userId}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<UserResponseModel> getUser(@PathVariable("userId") String userId) {

        UserDto userDto = userService.getUserDetailsByUserId(userId);
        UserResponseModel returnValue = new ModelMapper().map(userDto, UserResponseModel.class);

        return ResponseEntity.status(HttpStatus.OK).body(returnValue);
    }

//    @GetMapping("/username/{username}")
//    public ResponseEntity<UserResponseModel> byUsername(@PathVariable String username) throws UserNotFound {
//        userService.getUserDetailsByUsername(username)
//
//        if (cr.isEmpty()) {
//            throw new UserNotFound("Custormer with the username " + username + " is not found");
//        }
//        return new ResponseEntity<>(cr.get(), HttpStatus.FOUND);
//    }
//
////    @GetMapping("/search/name/{partName}")
////    public ResponseEntity<Iterable<UserDto>> byName(@PathVariable String partName) {
////
////        Iterable<UserDto> usersFound = userService.getByName(partName);
////        return new ResponseEntity<>(usersFound, HttpStatus.OK);
////    }
//
////    @PostMapping(value = "/new_user")
////    @CrossOrigin
////    public ResponseEntity<String> saveUser(@RequestBody UserEntity userEntity) {
////        System.out.println("user");
////
////        userService.saveUser(userEntity);
////
////        return new ResponseEntity<>("Successfully created", HttpStatus.ACCEPTED);
////    }
//
//    @PostMapping("/activate")
//    public ResponseEntity<String> activateUser(@RequestBody ActivationBody activationBody) throws AccountActivationException {
//        this.userService.activate(activationBody.username, activationBody.email, activationBody.id);
//        return new ResponseEntity<>("Activation Successfull", HttpStatus.ACCEPTED);
//    }
//
//    @AllArgsConstructor
//    static class ActivationBody {
//        String username;
//        String email;
//        int id;
//    }
}
