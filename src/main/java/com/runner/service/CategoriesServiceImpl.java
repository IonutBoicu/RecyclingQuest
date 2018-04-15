package com.runner.service;

import com.runner.domain.RecyclingCategories;
import com.runner.repository.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoriesServiceImpl implements CategoriesService {

    private CategoriesRepository categoriesRepository;

    @Autowired
    public CategoriesServiceImpl(CategoriesRepository categoriesRepository) {
        this.categoriesRepository = categoriesRepository;
    }

    @Override
    public List<RecyclingCategories> showAll() {
        List<RecyclingCategories> cats = new ArrayList<>();
        categoriesRepository.findAll().forEach(cats::add);
        return  cats;
    }

    @Override
    public RecyclingCategories getById(Long id) {
        return categoriesRepository.findOne(id);
    }

    @Override
    public List<RecyclingCategories> filterByCategory(String category) {
        return categoriesRepository.findAllByMaterialIsLike(category);
    }

    @Override
    public void saveOrUpdate(RecyclingCategories recyclingCategories) {
        categoriesRepository.save(recyclingCategories);
    }

    @Override
    public void delete(Long id) {
        categoriesRepository.delete(id);
    }
}
