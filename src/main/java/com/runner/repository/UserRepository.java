package com.runner.repository;

import com.runner.domain.UserProfile;
import org.apache.catalina.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<UserProfile, Long> {

    UserProfile findByUsernameAndPassword(String username, String password);

    UserProfile findByUsername(String username);
}
