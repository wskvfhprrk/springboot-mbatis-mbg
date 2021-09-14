package com.example.autoCode;

import lombok.Data;

@Data
public class TableName {
    private String tableName;
    private String moduleName;

    public TableName() {
    }

    public TableName(String tableName, String moduleName) {
        this.tableName = tableName;
        this.moduleName = moduleName;
    }
}
