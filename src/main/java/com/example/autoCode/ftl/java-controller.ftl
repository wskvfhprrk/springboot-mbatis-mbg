package ${controllerPackage};

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import ${entityPackage}.${className?cap_first};
import ${servicePackage}.${className?cap_first}Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;
import javax.validation.constraints.*;
import ${basePackage}.dto.*;

import java.util.*;
import javax.validation.*;

/**
* Created by 代码自动生成.
* 时间:${.now?string("yyyy-MM-dd HH:mm:ss")}
*/
@Api("${moduleName}控制器")
@RestController
@RequestMapping("${className}")
public class ${className?cap_first}Controller {

    @Autowired
    public ${className?cap_first}Service service;

    @GetMapping
	@ApiOperation("分页条件查询${moduleName}")
    public ResponseEntity getPage(@Validated ${className?cap_first}PageDto dto){
        return service.findPage${className?cap_first}(dto);
    }

    @GetMapping("all")
    @ApiOperation("获取所有${moduleName}")
    public ResponseEntity getAll(){
        return service.getAll();
    }
<#if idNumber!=0>
    @PostMapping
	@ApiOperation("添加${moduleName}")
    public ResponseEntity add(@Validated @RequestBody ${className?cap_first}SaveDto dto){
        return service.insert(dto);
    }

    @PutMapping
	@ApiOperation("修改${moduleName}")
    public ResponseEntity update(@Validated @RequestBody ${className?cap_first}UpdateDto dto){
        return service.update(dto);
    }
    
    @DeleteMapping("/{<#list data as d><#if d.id==true>${d.beanName}</#if></#list>}")
	@ApiOperation("根据ID删除")
    public ResponseEntity deleteById(@PathVariable <#list data as d><#if d.id==true>${d.type} ${d.beanName}</#if></#list>){
        return service.deleteById(<#list data as d><#if d.id==true>${d.beanName}</#if></#list>);
    }

    @GetMapping("/{<#list data as d><#if d.id==true>${d.beanName}</#if></#list>}")
    @ApiOperation("根据ID查询")
    public ResponseEntity getById(@PathVariable <#list data as d><#if d.id==true>${d.type} ${d.beanName}</#if></#list>){
        return service.getById(<#list data as d><#if d.id==true>${d.beanName}</#if></#list>);
    }</#if>
}
