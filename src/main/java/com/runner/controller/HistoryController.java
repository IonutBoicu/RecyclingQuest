package com.runner.controller;

import com.runner.domain.Centers;
import com.runner.domain.UserHistory;
import com.runner.domain.UserProfile;
import com.runner.service.CentersService;
import com.runner.service.HistoryService;
import com.runner.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/history")
public class HistoryController {

    private HistoryService historyService;
    private UserService userService;

    public HistoryController(HistoryService historyService, UserService userService) {
        this.historyService = historyService;
        this.userService = userService;
    }

    @Autowired


    @GetMapping(value = "/showAll", produces = "application/json")
    public @ResponseBody
    List<UserHistory> getHistories() {
        return historyService.showAll();
    }

    @GetMapping(value = "/findId", produces = "application/json")
    public @ResponseBody
    UserHistory getUserById(@RequestParam("id") long id) {
        return historyService.getById(id);
    }

    @DeleteMapping(value = "/deleteId")
    public @ResponseBody String deleteUserById(@RequestParam("id") long id) {
        if (historyService.getById(id) != null) {
            historyService.delete(id);
            return "UserHistory Deleted";
        }
        return "UserHistory Not found";
    }

    @PostMapping(value = "/newTransaction")
    public @ResponseBody boolean newTransaction(@RequestParam("username") String username,
                                                @RequestParam("center") String center,
                                                @RequestParam("date")String date,
                                                @RequestParam("weight")double weight,
                                                @RequestParam("material")String material) {
        UserProfile userProfile = userService.findByusername(username);
        UserHistory userHistory = new UserHistory(null,weight,date,center, userProfile, material);
        historyService.saveOrUpdate(userHistory);
        return true;
    }

    @PostMapping(value = "/update", consumes = "application/json")
    public @ResponseBody String updateUser(@RequestBody UserHistory userHistory) {
        if (userHistory != null) {
            historyService.saveOrUpdate(userHistory);
            return "UserHistory saved";
        }
        return "UserHistory saving error";
    }
}
