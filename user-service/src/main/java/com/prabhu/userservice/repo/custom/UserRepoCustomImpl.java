package com.prabhu.userservice.repo.custom;

import com.prabhu.userservice.entities.User;
import com.prabhu.userservice.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.EntityManager;
import java.util.Optional;

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
        User user = repo.findById(userId).get();
        user.setConfirmed(true);
        repo.save(user);
    }
}
