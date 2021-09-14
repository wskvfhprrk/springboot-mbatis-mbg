package com.example.autoCode;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.internal.DefaultCommentGenerator;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 自定义mybatis generator规则——generatorConfig.xml配置中对对应
 */
public class CommentGenerator extends DefaultCommentGenerator {
    private static final String EXAMPLE_SUFFIX = "Example";
    private static final String MAPPER_SUFFIX = "Mapper";
    private static final String API_MODEL_PROPERTY_FULL_CLASS_NAME = "io.swagger.annotations.ApiModelProperty";
    private Properties properties;
    private Properties systemPro;
    private boolean suppressDate;
    private boolean suppressAllComments;
    private String currentDateStr;

    public CommentGenerator() {
        super();
        properties = new Properties();
        systemPro = System.getProperties();
        currentDateStr = (new SimpleDateFormat("yyyy-MM-dd")).format(new Date());
    }

    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable,
                                IntrospectedColumn introspectedColumn) {
        StringBuilder sb = new StringBuilder();
        sb.append("@ApiModelProperty(\"");
        sb.append(introspectedColumn.getRemarks());
        sb.append("\")");
        field.addJavaDocLine(sb.toString());
    }

    /**
     * 添加配置属性
     *
     * @param properties
     */
    @Override
    public void addConfigurationProperties(Properties properties) {
        //使用geratorConfig.xml的配置项
        this.suppressDate= Boolean.parseBoolean(properties.getProperty("suppressDate"));
        this.suppressAllComments=Boolean.parseBoolean(properties.getProperty("suppressAllComments"));
    }

    /**
     * 添加模型类注释——可以在此添加其它代码生成（service和controller及前端）
     *
     * @param topLevelClass
     * @param introspectedTable
     */
    @Override
    public void addModelClassComment(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        //代码自动生成——service和controller
        Entity entity = new Entity(introspectedTable.getFullyQualifiedTableNameAtRuntime(), introspectedTable.getRemarks());
        List<Entity.data> dataList=new ArrayList<>();
        //把主键参数添加进去——一般主键放在前面
        introspectedTable.getPrimaryKeyColumns().stream().forEach(c -> {
            Entity.data data = new Entity.data();
            data.setCommentName(c.getRemarks());
            data.setColumnName(c.getJavaProperty());
            data.setBeanName(AutoCodeUtil.getBeanName(c.getJavaProperty()));
            data.setType(c.getFullyQualifiedJavaType().getShortName());
            data.setId(true);//主键
            data.setExtpa(c.isAutoIncrement());
            data.setIsNull(c.isNullable());
            data.setMaximumLength(String.valueOf(c.getLength()));
            dataList.add(data);
        });
        //其它参数再添加进去
        introspectedTable.getBaseColumns().stream().forEach(c -> {
            Entity.data data = new Entity.data();
            data.setCommentName(c.getRemarks());
            data.setBeanName(AutoCodeUtil.getBeanName(c.getJavaProperty()));
            data.setColumnName(c.getJavaProperty());
            data.setType(c.getFullyQualifiedJavaType().getShortName());
            data.setId(false);
            data.setExtpa(false);
            data.setIsNull(c.isNullable());
            data.setMaximumLength(String.valueOf(c.getLength()));
            dataList.add(data);
        });
        CreateEntity createEntity = new CreateEntity(introspectedTable.getFullyQualifiedTableNameAtRuntime(), entity, dataList);
        entity = createEntity.createEntity(entity);
        CreateCodeService createCodeService=new CreateCodeService();
        createCodeService.creatCode(entity);
    }

    /**
     * 添加类注释
     *
     * @param innerClass
     * @param introspectedTable
     */
    @Override
    public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable) {

    }

    @Override
    public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable, boolean b) {
    }

    @Override
    public void addEnumComment(InnerEnum innerEnum, IntrospectedTable introspectedTable) {
    }

    @Override
    public void addGetterComment(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
    }

    @Override
    public void addSetterComment(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {

    }

    /**
     * 添加一般方法注释
     *
     * @param method
     * @param introspectedTable
     */
    @Override
    public void addGeneralMethodComment(Method method, IntrospectedTable introspectedTable) {

    }

    /**
     * 添加Java文件注释
     *
     * @param compilationUnit
     */
    @Override
    public void addJavaFileComment(CompilationUnit compilationUnit) {
        super.addJavaFileComment(compilationUnit);
        //只在model中添加swagger注解类的导入
        if (!compilationUnit.getType().getFullyQualifiedName().contains(MAPPER_SUFFIX) && !compilationUnit.getType().getFullyQualifiedName().contains(EXAMPLE_SUFFIX)) {
            compilationUnit.addImportedType(new FullyQualifiedJavaType(API_MODEL_PROPERTY_FULL_CLASS_NAME));
        }
    }

    @Override
    public void addComment(XmlElement xmlElement) {
    }

    @Override
    public void addRootComment(XmlElement xmlElement) {

    }

    /**
     * 添加常规方法注释
     *
     * @param method
     * @param introspectedTable
     * @param set
     */
    @Override
    public void addGeneralMethodAnnotation(Method method, IntrospectedTable introspectedTable, Set<FullyQualifiedJavaType> set) {
    }

    @Override
    public void addGeneralMethodAnnotation(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn, Set<FullyQualifiedJavaType> set) {

    }

    /**
     * 添加字段注释
     *
     * @param field
     * @param introspectedTable
     * @param set
     */
    @Override
    public void addFieldAnnotation(Field field, IntrospectedTable introspectedTable, Set<FullyQualifiedJavaType> set) {

    }

    /**
     * 添加字段注释——不生成任何东西
     *
     * @param field
     * @param introspectedTable
     * @param introspectedColumn
     * @param set
     */
    @Override
    public void addFieldAnnotation(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn, Set<FullyQualifiedJavaType> set) {
    }

    /**
     * 不产生逻辑
     *
     * @param innerClass
     * @param introspectedTable
     * @param set
     */
    @Override
    public void addClassAnnotation(InnerClass innerClass, IntrospectedTable introspectedTable, Set<FullyQualifiedJavaType> set) {
    }
}
