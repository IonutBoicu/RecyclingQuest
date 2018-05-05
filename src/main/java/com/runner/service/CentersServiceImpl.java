package com.runner.service;

import com.runner.domain.Centers;
import com.runner.repository.CenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CentersServiceImpl implements CentersService{

    private CenterRepository centerRepository;

    @Autowired
    CentersServiceImpl(CenterRepository centerRepository) {
        this.centerRepository = centerRepository;
    }

    @Override
    public List<Centers> showAll() {
        List<Centers> centers = new ArrayList<>();
        centerRepository.findAll().forEach(centers::add);
        return centers;
    }

    @Override
    public Centers getById(Long id) {
        return centerRepository.findOne(id);
    }

    @Override
    public void saveOrUpdate(Centers center) {
        centerRepository.save(center);
    }

    @Override
    public Centers findByName(String name) {
        return centerRepository.findByName(name);
    }

    @Override
    public List<Centers> findAllByMaterial(String material) {
        return centerRepository.findAllByMaterials(material);
    }

    @Override
    public void delete(Long id) {
        centerRepository.delete(id);
    }
}
