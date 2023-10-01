package com.example.debezium.service.impl;

import com.example.debezium.service.HistoryDetailService;
import com.example.debezium.service.HistoryStrategyService;
import com.example.debezium.enumeration.HistoryClassType;
import io.debezium.data.Envelope;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class HistoryDetailServiceImpl implements HistoryDetailService {

    private final Map<HistoryClassType, HistoryStrategyService> converterStrategyServiceMap;

    @Override
    public void saveHistory(Map<String, Object> data, Envelope.Operation operation, HistoryClassType historyClassType) {

        HistoryStrategyService historyStrategyService = converterStrategyServiceMap.get(historyClassType);
        historyStrategyService.saveHistory(data, operation);
    }
}
