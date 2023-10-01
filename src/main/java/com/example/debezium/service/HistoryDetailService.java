package com.example.debezium.service;

import com.example.debezium.enumeration.HistoryClassType;
import io.debezium.data.Envelope;

import java.util.Map;

public interface HistoryDetailService {

    void saveHistory(Map<String, Object> data, Envelope.Operation operation, HistoryClassType historyClassType);
}
