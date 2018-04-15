package com.runner.service;


import com.runner.domain.RecyclingCategories;

import java.util.List;

public interface CategoriesService {
    List<RecyclingCategories> showAll();

    RecyclingCategories getById(Long id);

    List<RecyclingCategories> filterByCategory(String category);

    void saveOrUpdate(RecyclingCategories recyclingCategories);

    void delete(Long id);
}
