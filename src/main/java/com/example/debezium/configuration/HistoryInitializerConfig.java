package com.example.debezium.configuration;

import com.example.debezium.service.HistoryStrategyService;
import com.example.debezium.enumeration.HistoryClassType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Configuration
public class HistoryInitializerConfig {

    @Bean
    public Map<HistoryClassType, HistoryStrategyService> initHistoryStrategyServices(List<HistoryStrategyService> historyStrategyServices) {
        return historyStrategyServices
                .stream()
                .collect(Collectors.toMap(HistoryStrategyService::getType, Function.identity()));
    }
}
