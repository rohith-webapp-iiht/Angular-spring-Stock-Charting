package com.prabhu.userservice.repo;

import com.prabhu.userservice.entities.User;
import com.prabhu.userservice.repo.custom.UserRepoCustom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * This belongs to user-service
 *
 * @author Prabhu Madipalli
 */

public interface UserRepo extends JpaRepository<User, Integer>, UserRepoCustom {


    boolean existsUserByUsername(String username);

    boolean existsUserByEmail(String email);

    Optional<User> findUserByUsername(String username);

    Optional<User> findUserByEmail(String email);

    Optional<User> findUserByMobileNumber(String mobileNumber);

    List<User> findUsersByFirstNameContainingOrLastNameContaining(String partName, String parName);
}
