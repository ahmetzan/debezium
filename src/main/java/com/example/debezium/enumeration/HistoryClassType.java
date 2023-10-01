package com.example.debezium.enumeration;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.Objects;

@Getter
@AllArgsConstructor
public enum HistoryClassType {

    CUSTOMER("customer");

    private final String value;

    public static HistoryClassType fromValue(String value) {

        return Arrays.stream(HistoryClassType.values())
                .filter(e -> Objects.equals(e.value, value))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Unknown ClassName. name: " + value));
    }
}
