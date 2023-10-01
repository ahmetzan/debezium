package com.example.debezium.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerSaveRequest {

    private Long id;
    private String name;
}
