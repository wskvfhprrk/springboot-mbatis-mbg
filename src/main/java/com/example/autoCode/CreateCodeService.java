package com.example.autoCode;

/**
 * 代码实现类
 *
 * @author 何建哲
 * @date 2018/6/20
 */
//@Service
public class CreateCodeService {

    public void creatCode(Entity entity) {
        // 生成实体类
        String ftlsuffixPath = "java-entity.ftl";
//        createCode(entity, ftlsuffixPath);
        //生成分页查询dto
        ftlsuffixPath = "java-dto-pageDto.ftl";
        createCode(entity, ftlsuffixPath);
        //生成添加dto
        ftlsuffixPath = "java-dto-saveDto.ftl";
        createCode(entity, ftlsuffixPath);
        //生成修改dto
        ftlsuffixPath = "java-dto-updateDto.ftl";
        createCode(entity, ftlsuffixPath);
        //生成分页查询Vo
        ftlsuffixPath = "java-vo-pageVo.ftl";
        createCode(entity, ftlsuffixPath);
        //生成单条查询Vo
        ftlsuffixPath = "java-vo-vo.ftl";
        createCode(entity, ftlsuffixPath);
        // 生成修改dto——没有主键
//        ftlsuffixPath = "java-dao-dao.ftl";
//        createCode(entity, ftlsuffixPath);
        // 生成daoSQL类
//        ftlsuffixPath = "java-dao-daoSql.ftl";
//        createCode(entity, ftlsuffixPath);
        // 生成service接口类
        ftlsuffixPath = "java-service-service.ftl";
        createCode(entity, ftlsuffixPath);
        // 生成controller实现类
        ftlsuffixPath = "java-service-serviceImpl.ftl";
        createCode(entity, ftlsuffixPath);
        ftlsuffixPath = "java-controller.ftl";
        createCode(entity, ftlsuffixPath);
        // 生成list页面
//        createListPage(entity);
        // 生成add页面
//        createAddPage(entity);*/
        //生成vue页面
        ftlsuffixPath = "vue-view.ftl";
        createCode(entity, ftlsuffixPath);
        //生成vue的index页面
        ftlsuffixPath = "vue-index.ftl";
        createCode(entity, ftlsuffixPath);
        //生成vue js页面
        ftlsuffixPath = "js-vue.ftl";
        createCode(entity, ftlsuffixPath);

    }

    /**
     * 生成代码
     *
     * @param entity        实体类
     * @param ftlsuffixPath 模板后缀名（格式要固定，否则程序报错） eag. js-vue.ftl js为输出文件后缀,vue为文件名或包名
     */
    private void createCode(Entity entity, String ftlsuffixPath) {
        //截取模板后缀名中的输出文件后缀
        String[] split = ftlsuffixPath.substring(0, ftlsuffixPath.indexOf(".")).split("-");
        String suffix = split[0];
        String pockName, fileName;
        pockName = split[1];
        if (pockName.equals("dao") || pockName.equals("vo") || pockName.equals("dto") || pockName.equals("service")) {
            fileName = split[2];
        } else {
            fileName = pockName;
        }
        StringBuffer addPathAndName = AutoCodeUtil.getPathByCom(AutoCodeConstant.basePackage);
        //ftl路径
        addPathAndName.append(AutoCodeConstant.ftlPath);
        addPathAndName.append(ftlsuffixPath);
        // 输出路径+名称
        StringBuffer addOutFile = new StringBuffer();
        /**
         * 输出路径时java的要看是否是vo\dto\impl\dao;
         * 如果是vue和js类型时；
         */
        if (suffix.equals("java")) {
            addOutFile.append(AutoCodeUtil.getPathByCom(AutoCodeConstant.basePackage +"."+ pockName));
            if (pockName.equals("dto") || pockName.equals("vo") || pockName.equals("dao")) {
                AutoCodeUtil.getPath(addOutFile.toString());
                addOutFile.append(AutoCodeUtil.captureName(entity.className()) + AutoCodeUtil.captureName(fileName) + "." + suffix);
            } else if (pockName.equals("service") && "service".equals(fileName)) {
                AutoCodeUtil.getPath(addOutFile.toString());
                addOutFile.append(AutoCodeUtil.captureName(entity.className()) + AutoCodeUtil.captureName(pockName) + "." + suffix);
            } else if (pockName.equals("service") && "serviceImpl".equals(fileName)) {
                addOutFile.append("Impl/");
                AutoCodeUtil.getPath(addOutFile.toString());
                addOutFile.append(AutoCodeUtil.captureName(entity.className()) + AutoCodeUtil.captureName(fileName) + "." + suffix);
            } else if (pockName.equals("entity")) {
                AutoCodeUtil.getPath(addOutFile.toString());
                addOutFile.append(AutoCodeUtil.captureName(entity.className()) + "." + suffix);
            } else {
                AutoCodeUtil.getPath(addOutFile.toString());
                addOutFile.append(AutoCodeUtil.captureName(entity.className()) + AutoCodeUtil.captureName(pockName) + "." + suffix);
            }
        } else if (suffix.equals("vue")) {
            addOutFile.append(AutoCodeConstant.vuePagePath );
            AutoCodeUtil.getPath(addOutFile.toString());
            addOutFile.append(entity.className()+"/");
            AutoCodeUtil.getPath(addOutFile.toString());
            addOutFile.append(pockName);
            addOutFile.append(".vue");
        } else {
            addOutFile.append(AutoCodeConstant.vuePagePath);
            // 先看是否存在路径没有先创建
            AutoCodeUtil.getPath(addOutFile.toString());
            addOutFile.append("/api/");
            AutoCodeUtil.getPath(addOutFile.toString());
            addOutFile.append(entity.className());
            addOutFile.append(".js");
        }
        AutoCodeUtil.getNewFile(addPathAndName.toString(), entity, addOutFile.toString());
//        System.out.println("-------------------------------------" + AutoCodeUtil.captureName(entity.className()) + "." + suffix + "生成完毕------------------------------------");
    }
}