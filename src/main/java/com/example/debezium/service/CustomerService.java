package com.example.debezium.service;

import com.example.debezium.request.CustomerSaveRequest;

public interface CustomerService {

    void saveOrUpdate(CustomerSaveRequest id);

    void deleteById(Long id);

    int bulkSave();
}
