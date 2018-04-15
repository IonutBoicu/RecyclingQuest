package com.runner.controller;

import com.runner.domain.Centers;
import com.runner.service.CentersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/centers")
public class CentersController {
    private CentersService centersService;

    @Autowired
    public CentersController(CentersService centersService) {
        this.centersService = centersService;
    }

    @GetMapping(value = "/showAll", produces = "application/json")
    public @ResponseBody
    List<Centers> getHistories() {
        return centersService.showAll();
    }

    @GetMapping(value = "/findId", produces = "application/json")
    public @ResponseBody
    Centers getUserById(@RequestParam("id") long id) {
        return centersService.getById(id);
    }

    @DeleteMapping(value = "/deleteId")
    public @ResponseBody String deleteUserById(@RequestParam("id") long id) {
        if (centersService.getById(id) != null) {
            centersService.delete(id);
            return "Center Deleted";
        }
        return "Center Not found";
    }

    @PostMapping(value = "/update", consumes = "application/json")
    public @ResponseBody String updateUser(@RequestBody Centers centers) {
        if (centers != null) {
            centersService.saveOrUpdate(centers);
            return "Center saved";
        }
        return "Center saving error";
    }
}
