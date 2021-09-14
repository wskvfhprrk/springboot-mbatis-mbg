package com.example.autoCode;

import lombok.Data;

/**
 * Created by Administrator on 2017/7/6.
 */
@Data
public class AutoCodeConstant {
    /**
     * 基础类包
     */
    public static String basePackage = "com.example";
    /**
     * 实体类包名
     */
    public static String entity = "model";
    /**
     * dto包名
     */
    public static String dto = "dto";
    /**
     * vo包名
     */
    public static String vo = "vo";
    /**
     * dao包名
     */
    public static String dao = "mapper";
    /**
     * service包名
     */
    public static String service = "service";
    /**
     * serviceImpl包名
     */
    public static String serviceImpl = "service.Impl";
    /**
     * controller包名
     */
    public static String controller = "controller";

    /**
     * html网页路径
     */
    public static String pagePath = "src/main/resources/templates/";
    /**
     * 模板路径前缀
     */
    public static String ftlPath = "autoCode/ftl/";
    /**
     * vue
     */
    public static String vuePagePath = "src/main/resources/vue/";

    /**
     * sql路径
     */
    public static String sqlPath="/Users/hejianzhe/IdeaProjects/djj-mis/src/main/addMenu.sql";
    /**
     * fullpath追加路径文件
     */
    public static String fullpath="/Users/hejianzhe/IdeaProjects/djj-mis/src/main/fullpath";


}
