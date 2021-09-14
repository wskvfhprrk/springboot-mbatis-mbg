package ${voPackage};

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
<#list data as d> <#if d.type=='BigDecimal'>
import java.math.BigDecimal;<#break></#if></#list>
<#list data as d> <#if d.type=='Timestamp' ||d.type=='Date'>
import java.util.Date;<#break></#if></#list>
/**
* Created by 代码自动生成.
* 时间:${.now?string("yyyy-MM-dd HH:mm:ss")}
*/
@ApiModel("${moduleName}实体类")
@Data
public class ${className?cap_first}Vo {
<#list data as d><#if d.type=="Timestamp" || d.type=='Date'>
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")</#if>
    @ApiModelProperty(value="${d.commentName}"<#if d.type="Timestamp">,example = "2001-10-10 11:11:11"</#if>)
    private <#if d.type=='Timestamp'>Date<#elseif d.type=="Time">String<#else>${d.type}</#if> ${d.beanName};
</#list>
}
