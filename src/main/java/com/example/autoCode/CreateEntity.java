package com.example.autoCode;

import java.util.List;

/**
 * 组合freemarker生成代码所需要的数据——Entity附加类
 */
public class CreateEntity {

    private Entity entity;

    public CreateEntity( Entity entity) {
        this.entity = entity;
    }

    public Entity createEntity(Entity entity) {
        // 原来表名
        entity.tableName(entity.tableName());
        // 模块名称---解释使用
        entity.moduleName(entity.moduleName());
        // java类名称(首字母小写)
        entity.className(AutoCodeUtil.getBeanName(entity.tableName()));
        // 基础包
        entity.basePackage(AutoCodeConstant.basePackage);
        // 实体类包名
        entity.entityPackage(AutoCodeConstant.basePackage + "." + AutoCodeConstant.entity);
        entity.dtoPackage(AutoCodeConstant.basePackage + "." + AutoCodeConstant.dto);
        entity.voPackage(AutoCodeConstant.basePackage + "." + AutoCodeConstant.vo);
        // dao类包名
        entity.daoPackage(AutoCodeConstant.basePackage + "." + AutoCodeConstant.dao);
        // service类包名
        entity.servicePackage(AutoCodeConstant.basePackage + "." + AutoCodeConstant.service);
        // serviceImpl类包名
        entity.serviceImplPackage(AutoCodeConstant.basePackage + "." + AutoCodeConstant.serviceImpl);
        // controller类包名
        entity.controllerPackage(AutoCodeConstant.basePackage + "." + AutoCodeConstant.controller);
        return entity;
    }

}
