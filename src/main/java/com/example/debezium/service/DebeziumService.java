package com.example.debezium.service;

import io.debezium.data.Envelope;

import java.util.Map;

public interface DebeziumService {

    void replicateData(Map<String, Object> data, Envelope.Operation operation, String tableName);


}
