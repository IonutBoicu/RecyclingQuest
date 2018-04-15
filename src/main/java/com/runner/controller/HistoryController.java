package com.runner.controller;

import com.runner.domain.UserHistory;
import com.runner.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/history")
public class HistoryController {

    private HistoryService historyService;

    @Autowired
    public HistoryController(HistoryService historyService) {
        this.historyService = historyService;
    }

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

    @PostMapping(value = "/update", consumes = "application/json")
    public @ResponseBody String updateUser(@RequestBody UserHistory userHistory) {
        if (userHistory != null) {
            historyService.saveOrUpdate(userHistory);
            return "UserHistory saved";
        }
        return "UserHistory saving error";
    }
}
