package com.runner.repository;

import com.runner.domain.Centers;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CenterRepository extends CrudRepository<Centers, Long>{

    Centers findByName(String name);

    List<Centers> findAllByMaterials(String material);
}
