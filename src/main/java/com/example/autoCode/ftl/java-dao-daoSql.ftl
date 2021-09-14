package ${daoPackage};

import ${entityPackage}.${className?cap_first};
import org.apache.ibatis.jdbc.SQL;
import org.apache.commons.lang3.StringUtils;

/**
* ${moduleName}SQL语句
* Created by 代码自动生成.
* 时间:${.now?string("yyyy-MM-dd HH:mm:ss")}
*/
public class ${className?cap_first}DaoSql {

    public static String select${className?cap_first}s(final ${className?cap_first} ${className}){
        return new SQL(){{
            SELECT("<#list data as d><#if d_index==0>a.${d.columnName}<#else> ,a.${d.columnName}</#if></#list>");
            FROM("${className} a");
            <#list data as d><#if d.type=='String'>
            if(${className}!=null && StringUtils.isNotBlank(${className}.get${d.beanName?cap_first}())){
                WHERE("a.${d.columnName?cap_first} like CONCAT('%',${r"#{"}${d.beanName}},'%')");
            }</#if><#if d.type!='String'>
            if(${className}!=null && ${className}.get${d.beanName?cap_first}()!=null && ${className}.get${d.beanName?cap_first}().toString().length()>0){
                WHERE("a.${d.columnName?cap_first} = ${r"#{"}${d.beanName}}");
            }</#if></#list>
        }}.toString();
    }

    public static String insert(final ${className?cap_first} ${className}){
        return new SQL(){{
            INSERT_INTO("${className}");
            <#list data as d><#if d.type=='String'>
            if(StringUtils.isNotBlank(${className}.get${d.beanName?cap_first}())){<#else>
            if(${className}.get${d.beanName?cap_first}()!=null && ${className}.get${d.beanName?cap_first}().toString().length()>0){</#if>
                <#assign str = "#\{"/>
                VALUES("${d.columnName}", "${str}${d.beanName}}");
            }
            </#list>
    }}.toString();
    }

    public static String update(final ${className?cap_first} ${className}){
        return new SQL(){{
            UPDATE("${className}");
            <#list data as d><#if d.type=='String'>
                if(StringUtils.isNotBlank(${className}.get${d.beanName?cap_first}())){<#else>
                if(${className}.get${d.beanName?cap_first}()!=null && ${className}.get${d.beanName?cap_first}().toString().length()>0){</#if><#assign str = "#\{"/>
                SET("${d.columnName} = ${str}${d.beanName}}");
            }
            </#list>
            <#list data as d><#if d.id=true><#if d.type=='String'>
                if(StringUtils.isNotBlank(${className}.get${d.beanName?cap_first}())){<#else>
                if(${className}.get${d.beanName?cap_first}()!=null && ${className}.get${d.beanName?cap_first}().toString().length()>0){</#if><#assign str = "#\{"/>
                WHERE("${d.columnName} = ${str}${d.beanName}}");
            }
            </#if></#list>
        }}.toString();
    }

    public static String delete(final ${className?cap_first} ${className}){
        return new SQL(){{
            DELETE_FROM("${className}");
            <#list data as d><#if d.type=='String'>
                if(StringUtils.isNotBlank(${className}.get${d.beanName?cap_first}())){<#else>
                if(${className}.get${d.beanName?cap_first}()!=null && ${className}.get${d.beanName?cap_first}().toString().length()>0){</#if><#assign str = "#\{"/>
                WHERE("${d.columnName} = ${str}${d.beanName}}");
            }
            </#list>
        }}.toString();
    }
}
