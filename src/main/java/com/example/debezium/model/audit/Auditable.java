package com.example.debezium.model.audit;

public interface Auditable {

    Audit getAudit();

    void setAudit(Audit audit);

}
