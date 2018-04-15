package com.runner.controller;

import com.runner.domain.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.runner.service.UserService;

import java.util.List;

@Controller
@RequestMapping(value = "/users")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping(value = "/showAll", produces = "application/json")
    public @ResponseBody
    List<UserProfile> getUsers() {
        return userService.showAll();
    }

    @GetMapping(value = "/findId", produces = "application/json")
    public @ResponseBody
    UserProfile getUserById(@RequestParam("id") long id) {
        return userService.getById(id);
    }

    @DeleteMapping(value = "/deleteId")
    public @ResponseBody String deleteUserById(@RequestParam("id") long id) {
        if (userService.getById(id) != null) {
            userService.delete(id);
            return "UserProfile Deleted";
        }
        return "UserProfile Not found";
    }

    @PostMapping(value = "/update", consumes = "application/json")
    public @ResponseBody String updateUser(@RequestBody UserProfile userProfile) {
        System.out.print("#################" + userProfile.getName());
        if (userProfile != null) {
            userService.saveOrUpdate(userProfile);
            return "UserProfile saved";
        }
        return "UserProfile saving error";
    }
}
