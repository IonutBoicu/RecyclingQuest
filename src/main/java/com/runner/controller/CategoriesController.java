package com.runner.controller;

import com.runner.domain.RecyclingCategories;
import com.runner.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/categories")
public class CategoriesController {
    private CategoriesService categoriesService;

    @Autowired
    public CategoriesController(CategoriesService categoriesService) {
        this.categoriesService = categoriesService;
    }

    @GetMapping(value = "/showAll", produces = "application/json")
    public @ResponseBody List<RecyclingCategories> showAll() {
        return categoriesService.showAll();
    }

    @GetMapping(value = "/filterByCat", produces = "application/json")
    public @ResponseBody List<RecyclingCategories> filterByCategory(@RequestParam("category")String category) {
        return categoriesService.filterByCategory(category);
    }

    @GetMapping(value = "/findId", produces = "application/json")
    public @ResponseBody RecyclingCategories getById(@RequestParam("id")Long id) {
        return categoriesService.getById(id);
    }

    @PostMapping(value = "/update", consumes = "application/json")
    public @ResponseBody String updateCategory(@RequestBody RecyclingCategories recyclingCategories) {
        if (recyclingCategories != null) {
            categoriesService.saveOrUpdate(recyclingCategories);
            return "Recycling category saved";
        }
        return "Category null";
    }

    @DeleteMapping(value = "/delete")
    public @ResponseBody String deleteCategory(@RequestParam("id")Long id) {
        if (categoriesService.getById(id) != null) {
            categoriesService.delete(id);
            return "Deleted";
        }
        return "Recycling Category not found";
    }
}
