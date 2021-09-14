package com.example.autoCode;

public class CreateEntity {

    private Entity entity;

    public CreateEntity( Entity entity) {
        this.entity = entity;
    }

    public Entity createEntity(Entity entity) {
        // 原来表名
        entity.setTableName(entity.getTableName());
        // 模块名称---解释使用
        entity.setModuleName(entity.getModuleName());
        // java类名称(首字母小写)
        entity.setClassName(AutoCodeUtil.getBeanName(entity.getTableName()));
        // 基础包
        entity.setBasePackage(AutoCodeConstant.basePackage);
        // 实体类包名
        entity.setEntityPackage(AutoCodeConstant.basePackage + "." + AutoCodeConstant.entity);
        entity.setDtoPackage(AutoCodeConstant.basePackage + "." + AutoCodeConstant.dto);
        entity.setVoPackage(AutoCodeConstant.basePackage + "." + AutoCodeConstant.vo);
        // dao类包名
        entity.setDaoPackage(AutoCodeConstant.basePackage + "." + AutoCodeConstant.dao);
        // service类包名
        entity.setServicePackage(AutoCodeConstant.basePackage + "." + AutoCodeConstant.service);
        // serviceImpl类包名
        entity.setServiceImplPackage(AutoCodeConstant.basePackage + "." + AutoCodeConstant.serviceImpl);
        // controller类包名
        entity.setControllerPackage(AutoCodeConstant.basePackage + "." + AutoCodeConstant.controller);
        return entity;
    }

}
