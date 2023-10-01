package com.example.debezium.repository;

import com.example.debezium.model.entity.CustomerHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerHistoryRepository extends JpaRepository<CustomerHistory, Long> {
}
