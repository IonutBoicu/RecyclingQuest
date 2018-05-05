package com.runner.controller;

import com.runner.domain.SensorBin;
import com.runner.domain.UserProfile;
import com.runner.service.SensorService;
import com.runner.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/sensors")
public class SensorController {
    private SensorService sensorService;
    private UserService userService;

    @Autowired
    public SensorController(SensorService sensorService, UserService userService) {
        this.sensorService = sensorService;
        this.userService = userService;
    }




    @GetMapping(value = "/showAll", produces = "application/json")
    public @ResponseBody
    List<SensorBin> getHistories() {
        return sensorService.showAll();
    }

    @GetMapping(value = "/findId", produces = "application/json")
    public @ResponseBody
    SensorBin getUserById(@RequestParam("id") long id) {
        return sensorService.getById(id);
    }

    @DeleteMapping(value = "/deleteId")
    public @ResponseBody String deleteUserById(@RequestParam("id") long id) {
        if (sensorService.getById(id) != null) {
            sensorService.delete(id);
            return "Center Deleted";
        }
        return "Center Not found";
    }

    @PostMapping(value = "/update")
    public @ResponseBody
    boolean updateUser(@RequestParam("material")String material,
                      @RequestParam("owner")String username,
                      @RequestParam("percentage")Float percentage) {
        UserProfile userProfile = userService.findByusername(username);
        SensorBin sensorBin = sensorService.findByUserProfile(userProfile);
        sensorBin.setPercentage(percentage);
        sensorService.saveOrUpdate(sensorBin);
        return true;
    }
}
