package com.prabhu.userservice.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prabhu.userservice.entities.UserEntity;
import com.prabhu.userservice.repo.custom.UserRepoCustom;

/**
 * This belongs to user-service
 *
 * @author Prabhu Madipalli
 */

public interface UserRepo extends JpaRepository<UserEntity, Integer>, UserRepoCustom {


    boolean existsUserEntityByUsername(String username);

    boolean existsUserEntityByEmail(String email);

    Optional<UserEntity> findUserEntityByUsername(String username);

    Optional<UserEntity> findUserEntityByEmail(String email);

    Optional<UserEntity> findUserEntityByMobileNumber(String mobileNumber);

    List<UserEntity> findUserEntitiesByFirstNameContainingOrLastNameContaining(String partName, String parName);

    Optional<UserEntity> findUserEntityByUserId(String userId);

}
