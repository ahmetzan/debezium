package com.example.debezium.model.converter;

import com.example.debezium.model.entity.CustomerHistory;
import io.debezium.data.Envelope;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;
import java.util.Objects;

@Component
public class CustomerHistoryEventConverter {

    public CustomerHistory convert(Map<String, Object> data, Envelope.Operation operation) {

        if (Objects.isNull(data)) {
            return null;
        }

        CustomerHistory customerHistory = new CustomerHistory();
        customerHistory.setName((String) data.get("name"));
        customerHistory.setCustomerId((Long) data.get("id"));
        customerHistory.setCreatedBy((String) data.get("createdBy"));
        customerHistory.setLastModifiedBy((String) data.get("lastModifiedBy"));
        customerHistory.setType(operation.name());

        Object createdDate = data.get("createdDate");
        if (Objects.nonNull(createdDate)) {
            customerHistory.setCreatedDate(new Date((Long) createdDate));
        }

        Object lastModifiedDate = data.get("lastModifiedDate");
        if (Objects.nonNull(lastModifiedDate)) {
            customerHistory.setLastModifiedDate(new Date((Long) lastModifiedDate));
        }
        return customerHistory;
    }
}
