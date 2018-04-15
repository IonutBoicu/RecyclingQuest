package com.runner.service;

import com.runner.domain.UserHistory;

import java.util.List;


public interface HistoryService {
    List<UserHistory> showAll();

    UserHistory getById(Long id);

    void saveOrUpdate(UserHistory userHistory);

    void delete(Long id);
}
