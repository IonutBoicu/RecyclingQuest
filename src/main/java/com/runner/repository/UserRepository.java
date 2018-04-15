package com.runner.repository;

import com.runner.domain.UserProfile;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<UserProfile, Long> {
}
