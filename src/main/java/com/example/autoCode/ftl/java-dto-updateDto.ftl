package ${dtoPackage};

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.*;
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
public class ${className?cap_first}UpdateDto {
<#list data as d><#if d.type=="Timestamp" || d.type=='Date'>
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")</#if>
    @ApiModelProperty("${d.commentName}") <#if d.type=='String'>
    @NotBlank(message = "${d.commentName}不能为空值")<#else>@NotNull(message = "${d.commentName}不能为空值")
</#if>
    private <#if d.type=='Timestamp'>Date<#elseif d.type=="Time">String<#else>${d.type}</#if> ${d.beanName};
</#list>
}
