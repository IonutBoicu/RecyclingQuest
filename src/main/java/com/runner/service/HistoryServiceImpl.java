package com.runner.service;

import com.runner.domain.UserHistory;
import com.runner.repository.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HistoryServiceImpl implements HistoryService {

    private HistoryRepository historyRepository;

    @Autowired
    public HistoryServiceImpl(HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }

    @Override
    public List<UserHistory> showAll() {
        List<UserHistory> histories = new ArrayList<>();
        historyRepository.findAll().forEach(histories::add);
        return histories;
    }

    @Override
    public UserHistory getById(Long id) {
        return historyRepository.findOne(id);
    }

    @Override
    public void saveOrUpdate(UserHistory userHistory) {
        historyRepository.save(userHistory);
    }

    @Override
    public void delete(Long id) {
        historyRepository.delete(id);
    }
}
