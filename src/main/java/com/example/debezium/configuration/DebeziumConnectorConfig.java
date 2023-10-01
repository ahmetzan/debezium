package com.example.debezium.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DebeziumConnectorConfig {

    @Bean
    public io.debezium.config.Configuration customerConnector() {

        return io.debezium.config.Configuration.create()
                .with("name", "customer-postgres-connector")
                .with("connector.class", "io.debezium.connector.postgresql.PostgresConnector")
                .with("offset.storage", "org.apache.kafka.connect.storage.FileOffsetBackingStore")
                .with("offset.storage.file.filename", "/tmp/offsets.dat")
                .with("offset.flush.interval.ms", "60")
                .with("database.hostname", "localhost")
                .with("database.port", 5432)
                .with("database.user", "azan")
                .with("database.dbname", "postgres")
                .with("database.schema", "debezium")
                .with("schema.exclude.list", "envers,trigger")
                .with("database.server.name", "cdc-service")
                .with("table.exclude.list", "debezium.customer_history")
                .with("debezium.sink.type", "table")
                .with("debezium.sink.table.include.list", "customer")
                .with("debezium.payload.format", "debezium")
                .with("topic.prefix", "cdc-service")
                .with("plugin.name", "pgoutput")
                .build();
    }
}
