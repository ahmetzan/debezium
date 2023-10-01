package com.example.debezium.service.impl;

import com.example.debezium.enumeration.HistoryClassType;
import com.example.debezium.model.audit.Audit;
import com.example.debezium.model.converter.CustomerHistoryEventConverter;
import com.example.debezium.model.entity.Customer;
import com.example.debezium.model.entity.CustomerHistory;
import com.example.debezium.repository.CustomerHistoryRepository;
import com.example.debezium.service.HistoryStrategyService;
import io.debezium.data.Envelope;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class CustomerHistoryStrategyServiceImpl implements HistoryStrategyService {

    private final CustomerHistoryRepository customerHistoryRepository;
    private final CustomerHistoryEventConverter customerHistoryEventConverter;


    @Override
    public void saveHistory(Map<String, Object> data, Envelope.Operation operation) {

        customerHistoryRepository.save(customerHistoryEventConverter.convert(data, operation));
    }

    @Override
    public HistoryClassType getType() {
        return HistoryClassType.CUSTOMER;
    }
}
