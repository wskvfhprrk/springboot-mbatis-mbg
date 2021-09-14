package com.example.autoCode;

import lombok.*;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * 有用的数据库字段名称
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@With
public class Entity {

    private String tableName;
    private String moduleName;
    private String className;
    private String basePackage;
    private String entityPackage;
    private String dtoPackage;
    private String voPackage;
    private String daoPackage;
    private String servicePackage;
    private String serviceImplPackage;
    private String controllerPackage;
    private List<data> data;
    /**
     * 主键数量值
     */
    private Integer idNumber;


    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @With
    public static class data {
        /**
         * 数据库备注——中文
         */
        private String commentName;
        /**
         * javaBean字段名
         */
        private String beanName;
        /**
         * 行数据库名称
         */
        private String columnName;
        /**
         * 类型
         */
        private String type;
        /**
         * 数据允许的最大值
         */
        private String maximumLength;

        /**
         * 是否充许为空值
         */
        private Boolean isNull;
        /**
         * 是否为主键
         */
        private Boolean id;
        /**
         * 是否为主键数据自增
         */
        private Boolean extpa;

    }

}
