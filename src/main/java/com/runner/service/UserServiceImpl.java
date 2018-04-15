package com.runner.service;

import com.runner.domain.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.runner.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserProfile> showAll() {
        List<UserProfile> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    public UserProfile getById(Long id) {
        return userRepository.findOne(id);
    }

    public void saveOrUpdate(UserProfile userProfile) {
        userRepository.save(userProfile);
    }

    public void delete(Long id) {
        userRepository.delete(id);
    }


}
