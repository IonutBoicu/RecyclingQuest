package com.runner.service;


import com.runner.domain.Centers;

import java.util.List;

public interface CentersService {
    List<Centers> showAll();

    Centers getById(Long id);

    void saveOrUpdate(Centers userHistory);

    void delete(Long id);

    Centers findByName(String name);

    List<Centers> findAllByMaterial(String material);
}
