package ${servicePackage};

import ${entityPackage}.${className?cap_first};
import ${basePackage}.dto.*;
import org.springframework.http.ResponseEntity;
import java.util.*;

/**
* ${moduleName}方法类接口
* Created by 代码自动生成.
* 时间:${.now?string("yyyy-MM-dd HH:mm:ss")}
*/
public interface ${className?cap_first}Service {
    /**
    * 分页查询
    * @param dto 条件参数
    * @return easyui结果集
    */
    ResponseEntity findPage${className?cap_first}( ${className?cap_first}PageDto dto);

    /**
    * 获取所有商圈
    * @return
    */
    ResponseEntity getAll();

    /**
    * 添加${moduleName}
    * @param dto 条件参数
    * @return 结果集
    */
    ResponseEntity insert(${className?cap_first}SaveDto dto);
    /**
    * 修改${moduleName}
    * @param dto 条件参数
    * @return 结果集
    */
    ResponseEntity update(${className?cap_first}UpdateDto dto);

    /**
    * 根据主键删除${moduleName}
    * @param <#list data as d><#if d.id==true>${d.beanName}</#if></#list> 主键值
    * @return 结果集
    */
    ResponseEntity deleteById(<#list data as d><#if d.id==true>${d.type} ${d.beanName}</#if></#list>);

    /**
    * 批量删除${moduleName}
    * @param ids 以逗号隔开的主键字符串,对于单个id也适用
    * @return 结果集
    */
    ResponseEntity deleteAll(String ids);

    /**
    * 根据id查询${moduleName}
    * @param <#list data as d><#if d.id==true>${d.beanName}</#if></#list>
    * @return
    */
    ResponseEntity getById(<#list data as d><#if d.id==true>${d.type} ${d.beanName}</#if></#list>);
}
