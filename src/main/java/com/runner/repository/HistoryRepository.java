package com.runner.repository;

import com.runner.domain.UserHistory;
import org.springframework.data.repository.CrudRepository;

public interface HistoryRepository extends CrudRepository<UserHistory, Long>{

}
