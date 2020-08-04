package com.example.testDemo.utils;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author jianghy
 * 代码生成器
 * @date 2020-4-17 13:23
 */
@Slf4j
public class CodeGenerator {

    private final static String APP_PROPERTY = "code-generator.properties";

    public static void main(String[] args) {
        // 获取配置文件信息
        Properties properties = getProperties();
        // 生成的作者
        String author = properties.getProperty("gen.author");
        // 生成的包名
        String packageName = properties.getProperty("gen.base.package");
        // 生成的模块名
        String moduleName = properties.getProperty("gen.base.package.module");
        // 生成的表名
        String tableName = properties.getProperty("gen.table.name");
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor(author);
        gc.setOpen(false);
        gc.setSwagger2(true); //实体属性 Swagger2 注解
        gc.setDateType(DateType.ONLY_DATE);//这里我们不使用jdk8的时间
        mpg.setGlobalConfig(gc);

        // 数据源配置
        mpg.setDataSource(loadDataSourceConfig(properties));

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName(moduleName);
        pc.setParent(packageName);
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };



        // 自定义controller的代码模板
        String templatePath = "/templates/controller.java.ftl";
        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 + pc.getModuleName()
                String expand = projectPath + "/src/main/java/com/example/testDemo" +pc.getModuleName() + "/" + "controller";
                String entityFile = String.format((expand + File.separator + "%s" + ".java"), tableInfo.getControllerName());
                return entityFile;
            }
        });

        // 自定义mapper的代码模板
        templatePath = "/templates/mapper.xml.ftl";
        // 自定义输出配置
        focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/src/main/resources/mapper/" + pc.getModuleName()
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });

        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setXml(null);
//        templateConfig.setController(null);
        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);

        // 公共父类
//        strategy.setSuperControllerClass( packageName + ".common.base.CurdController");
        strategy.setInclude(tableName.split(","));
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix(pc.getModuleName() + "_");
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }


    /**
     * 配置数据库信息
     */
    private static DataSourceConfig loadDataSourceConfig(Properties prop) {
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(prop.getProperty("spring.datasource.url"));
        dsc.setDriverName(prop.getProperty("spring.datasource.driverClassName"));
        dsc.setUsername(prop.getProperty("spring.datasource.username"));
        dsc.setPassword(prop.getProperty("spring.datasource.password"));
        return dsc;
    }


    /**
     * 获取配置文件信息
     * @return
     */
    public static Properties getProperties() {
        Properties prop = new Properties();
        String resourcePath = System.getProperty("user.dir") + "/src/main/resources/" + APP_PROPERTY;
        try {
            InputStream inStream = new FileInputStream(new File(resourcePath));
            prop.load(inStream);
        }catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }
}