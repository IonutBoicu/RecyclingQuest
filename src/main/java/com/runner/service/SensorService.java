package com.runner.service;


import com.runner.domain.SensorBin;
import com.runner.domain.UserProfile;

import java.util.List;

public interface SensorService {
    List<SensorBin> showAll();

    SensorBin getById(Long id);

    void saveOrUpdate(SensorBin sensorBin);

    void delete(Long id);

    SensorBin findByUserProfile(UserProfile userProfile);
}
