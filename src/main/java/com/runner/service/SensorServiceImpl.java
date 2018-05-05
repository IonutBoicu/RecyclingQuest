package com.runner.service;

import com.runner.domain.SensorBin;
import com.runner.domain.UserProfile;
import com.runner.repository.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SensorServiceImpl implements SensorService{


    private SensorRepository sensorRepository;

    @Autowired
    public SensorServiceImpl(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    @Override
    public List<SensorBin> showAll() {
        List<SensorBin> sensors = new ArrayList<>();
        sensorRepository.findAll().forEach(sensors::add);
        return sensors;
    }

    @Override
    public SensorBin getById(Long id) {
        return sensorRepository.findOne(id);
    }

    @Override
    public void saveOrUpdate(SensorBin sensorBin) {
        sensorRepository.save(sensorBin);
    }

    @Override
    public void delete(Long id) {
        sensorRepository.delete(id);
    }

    @Override
    public SensorBin findByUserProfile(UserProfile userProfile) {
        return sensorRepository.findByOwner(userProfile);
    }
}
