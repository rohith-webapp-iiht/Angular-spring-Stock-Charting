package com.prabhu.userservice.controllers;

import com.prabhu.userservice.dto.UserDto;
import com.prabhu.userservice.entities.User;
import com.prabhu.userservice.exceptions.AccountActivationException;
import com.prabhu.userservice.exceptions.UserNotFound;
import com.prabhu.userservice.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * This belongs to user-service
 *
 * @author Prabhu Madipalli
 */

@RestController
@RequestMapping("/api/users")
public class UserController {


    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/all")
    public ResponseEntity<Iterable<UserDto>> getAll() {

        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<UserDto> byUsername(@PathVariable String username) throws UserNotFound {
        Optional<UserDto> cr = userService.findByUsername(username);

        if (cr.isEmpty()) {
            throw new UserNotFound("Custormer with the username " + username + " is not found");
        }
        return new ResponseEntity<>(cr.get(), HttpStatus.FOUND);
    }

    @GetMapping("/search/name/{partName}")
    public ResponseEntity<Iterable<UserDto>> byName(@PathVariable String partName) {

        Iterable<UserDto> usersFound = userService.getByName(partName);
        return new ResponseEntity<>(usersFound, HttpStatus.OK);
    }

    @PostMapping("/new_user")
    public ResponseEntity<String> saveUser(@RequestBody User user) {

        userService.saveCustomer(user);
        return new ResponseEntity<>("Account created", HttpStatus.ACCEPTED);
    }

    @PostMapping("/activate")
    public ResponseEntity<String> activateUser(@RequestBody ActivationBody activationBody) throws AccountActivationException {
        this.userService.activate(activationBody.username, activationBody.email, activationBody.id);
        return new ResponseEntity<>("Activation Successfull", HttpStatus.ACCEPTED);
    }

    @AllArgsConstructor
    static class ActivationBody {
        String username;
        String email;
        int id;
    }
}
