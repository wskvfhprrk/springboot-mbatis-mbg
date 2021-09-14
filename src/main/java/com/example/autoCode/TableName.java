package com.example.autoCode;

import lombok.Data;

@Data
public class TableName {
    private String className;
    private String moduleName;

    public TableName() {
    }

    public TableName(String className, String moduleName) {
        this.className = className;
        this.moduleName = moduleName;
    }
}
