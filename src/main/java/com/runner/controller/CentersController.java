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
    List<Centers> getCenters() {
        return centersService.showAll();
    }

    @GetMapping(value = "/findId", produces = "application/json")
    public @ResponseBody
    Centers getCenterById(@RequestParam("id") long id) {
        return centersService.getById(id);
    }

    @GetMapping(value = "/findByName", produces = "application/json")
    public @ResponseBody
    Centers getCenterByName(@RequestParam("name")String name) {
        return centersService.findByName(name);
    }

    @GetMapping(value = "/findAllByMaterial", produces = "application/json")
    public @ResponseBody
    List<Centers> getCentersByMaterial(@RequestParam("material")String material) {
        return centersService.findAllByMaterial(material);
    }

    @DeleteMapping(value = "/deleteId")
    public @ResponseBody String deleteCenterById(@RequestParam("id") long id) {
        if (centersService.getById(id) != null) {
            centersService.delete(id);
            return "Center Deleted";
        }
        return "Center Not found";
    }

    @PostMapping(value = "/update", consumes = "application/json")
    public @ResponseBody String updateCenter(@RequestBody Centers centers) {
        if (centers != null) {
            centersService.saveOrUpdate(centers);
            return "Center saved";
        }
        return "Center saving error";
    }
}
