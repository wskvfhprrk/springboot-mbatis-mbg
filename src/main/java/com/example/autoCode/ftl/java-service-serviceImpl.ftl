package ${serviceImplPackage};

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import ${daoPackage}.${className?cap_first}Mapper;
import ${entityPackage}.*;
import ${servicePackage}.${className?cap_first}Service;
import org.springframework.http.ResponseEntity;
import com.example.common.PageResponseEntity;
import ${basePackage}.dto.*;
import ${basePackage}.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;


/**
* ${moduleName}方法实现类
* Created by 代码自动生成.
* 时间:${.now?string("yyyy-MM-dd HH:mm:ss")}
*/
@Service
@Transactional
public class ${className?cap_first}ServiceImpl implements ${className?cap_first}Service {

    @Autowired
    private ${className?cap_first}Mapper ${className}Mapper;

    @Override
    public ResponseEntity findPage${className?cap_first}(${className?cap_first}PageDto dto) {
        PageResponseEntity pageResponseEntity=new PageResponseEntity();
        PageHelper.startPage(dto.getPageNumber(),dto.getPageSize());
        ${className?cap_first}Example example=new ${className?cap_first}Example();
        BeanUtils.copyProperties(dto,example);
        List<${className?cap_first}> list = ${className}Mapper.selectByExample(example);
        PageInfo<${className?cap_first}> info=new PageInfo<>(list);
        pageResponseEntity.setTotle(info.getTotal());
        pageResponseEntity.setPageSize(dto.getPageSize());
        pageResponseEntity.setPageNumber(dto.getPageNumber());
        //转换vo出去
        List<${className?cap_first}PageVo> vos = info.getList().stream().map(l -> {
            ${className?cap_first}PageVo vo = new ${className?cap_first}PageVo();
            BeanUtils.copyProperties(l, vo);
            return vo;
        }).collect(Collectors.toList());
        pageResponseEntity.setPages(vos);
        return ResponseEntity.ok(pageResponseEntity);
    }

    @Override
    public ResponseEntity getAll() {
        List<${className?cap_first}> ${className}s = ${className}Mapper.selectByExample(new ${className?cap_first}Example());
        return ResponseEntity.ok(${className}s);
    }

    @Override
    public ResponseEntity insert(${className?cap_first}SaveDto dto) {
        ${className?cap_first} ${className}=new ${className?cap_first}();
        BeanUtils.copyProperties(dto,${className});
        try{
            int insert = ${className}Mapper.insert(${className});
            return ResponseEntity.ok(insert);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity update(${className?cap_first}UpdateDto dto) {
        ${className?cap_first} ${className}=new ${className?cap_first}();
        BeanUtils.copyProperties(dto,${className});
        try{
            int i = ${className}Mapper.updateByPrimaryKey(${className});
            return ResponseEntity.ok(i);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity deleteById(<#list data as d><#if d.id==true>${d.type} ${d.beanName}</#if></#list>) {
        try{
            int i = ${className}Mapper.deleteByPrimaryKey(<#list data as d><#if d.id==true>${d.beanName}</#if></#list>);
            return ResponseEntity.ok(i);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity deleteAll(String <#list data as d><#if d.id==true>${d.beanName}</#if></#list>s) {
        try{
            String[] strings = <#list data as d><#if d.id==true>${d.beanName}</#if></#list>s.split(",");
            for (int i = 0; i <strings.length ; i++) {
            ${className}Mapper.deleteByPrimaryKey(<#list data as d><#if d.id==true&& d.type!='String'>${d.type}.valueOf(strings[i])<#elseif d.id==true&&d.type=='String'>strings[i]</#if></#list>);
        }
            return ResponseEntity.ok(1);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity getById(<#list data as d><#if d.id==true>${d.type} ${d.beanName}</#if></#list>) {
        ${className?cap_first} ${className} = ${className}Mapper.selectByPrimaryKey(<#list data as d><#if d.id==true>${d.beanName}</#if></#list>);
        return ResponseEntity.ok(${className});
    }
}
