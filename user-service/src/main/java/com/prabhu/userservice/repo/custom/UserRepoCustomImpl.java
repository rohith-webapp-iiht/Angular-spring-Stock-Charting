package com.prabhu.userservice.repo.custom;

import com.prabhu.userservice.entities.UserEntity;
import com.prabhu.userservice.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

/**
 * This belongs to user-service
 *
 * @author Prabhu Madipalli
 */

@Repository
public class UserRepoCustomImpl implements UserRepoCustom {
    @Autowired
    @Lazy
    private UserRepo repo;

    @Autowired
    @Lazy
    private EntityManager em;

    @Override
    public void setCondirmedTrue(int userId) {
        UserEntity userEntity = repo.findById(userId).get();
        userEntity.setConfirmed(true);
        repo.save(userEntity);
    }
}
