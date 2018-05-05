package com.runner.service;

import com.runner.domain.UserProfile;

import java.util.List;


public interface UserService {

    List<UserProfile> showAll();

    UserProfile getById(Long id);

    void saveOrUpdate(UserProfile userProfile);

    void delete(Long id);

    UserProfile checkuserpass(String username, String password);

    UserProfile findByusername(String username);
}