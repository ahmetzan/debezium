package com.example.debezium.service.impl;

import com.example.debezium.service.HistoryDetailService;
import com.example.debezium.enumeration.HistoryClassType;
import com.example.debezium.service.DebeziumService;
import io.debezium.data.Envelope.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class DebeziumServiceImpl implements DebeziumService {

    private final HistoryDetailService historyDetailService;

    @Override
    public void replicateData(Map<String, Object> data, Operation operation, String tableName) {

        historyDetailService.saveHistory(data, operation, HistoryClassType.fromValue(tableName));
    }

}
