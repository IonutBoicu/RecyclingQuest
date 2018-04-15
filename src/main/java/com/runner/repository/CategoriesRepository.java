package com.runner.repository;

import com.runner.domain.RecyclingCategories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriesRepository extends CrudRepository<RecyclingCategories, Long> {

    List<RecyclingCategories> findAllByMaterialIsLike(String material);
}
