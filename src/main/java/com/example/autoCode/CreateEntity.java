package com.example.autoCode;

import java.util.List;

public class CreateEntity {

    private String databaseName;
    private Entity entity;
    private List<Entity.data> dataList;

    public CreateEntity(String databaseName, Entity entity,List<Entity.data> dataList) {
        this.databaseName = databaseName;
        this.entity = entity;
        this.dataList=dataList;
    }

    public Entity createEntity(Entity entity) {
        if (dataList.isEmpty()) {
            return null;
        }
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
        List<Entity.data> data = dataList;
        entity.setData(data);
        //计算主键个数
        long count = data.stream().filter(Entity.data::getId).count();
        entity.setIdNumber((int) count);
        return entity;
    }

}
