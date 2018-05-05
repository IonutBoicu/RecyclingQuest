package com.runner.repository;


import com.runner.domain.SensorBin;
import com.runner.domain.UserProfile;
import org.springframework.data.repository.CrudRepository;

public interface SensorRepository extends CrudRepository<SensorBin, Long>{
    SensorBin findByOwner(UserProfile userProfile);
}
