package com.runner.repository;

import com.runner.domain.UserHistory;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by John on 4/15/2018.
 */
public interface HistoryRepository extends CrudRepository<UserHistory, Long>{

}
