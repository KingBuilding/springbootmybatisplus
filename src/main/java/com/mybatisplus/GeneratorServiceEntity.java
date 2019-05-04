package com.mybatisplus;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.mybatisplus.mapper.UserMapper;
import org.junit.Test;


import java.util.*;

public class GeneratorServiceEntity {

    @Test
    public void generateCode() {
        String packageName = "com.mybatisplustest.mybatisplustest";
        boolean serviceNameStartWithI = false;//user -> UserService, 设置成true: user -> IUserService
        generateByTables(serviceNameStartWithI, packageName, "user");
        UserMapper userMapper=null;

    }

    private void generateByTables(boolean serviceNameStartWithI, String packageName, String... tableNames) {
        //用来获取mybatis-plus.properties文件的配置信息
//        final ResourceBundle rb = ResourceBundle.getBundle("mybatis-plus");
        String dbUrl = "jdbc:mysql://localhost:3306/basic?serverTimezone=GMT";
        GlobalConfig config = new GlobalConfig();
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL)
                .setUrl(dbUrl)
                .setUsername("root")
                .setPassword("root")
                .setDriverName("com.mysql.jdbc.Driver");
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig
                .setEntityLombokModel(true) //设置lombok
                .setEntityBooleanColumnRemoveIsPrefix(true) // Boolean类型字段是否移除is前缀处理
                .setCapitalMode(true)
                .setDbColumnUnderline(true)
                .setNaming(NamingStrategy.underline_to_camel)
                .setInclude(tableNames);//修改替换成你需要的表名，多个表名传数组
        config.setActiveRecord(false)
                .setEnableCache(false)
                .setBaseResultMap(true)// XML ResultMap
                .setAuthor("jj")
                .setOutputDir("D:\\workspace for Maven\\mybatisplustest\\src\\main\\java")
                .setFileOverride(true);
        if (!serviceNameStartWithI) {
            config.setServiceName("%sService");
        }

        // 注入自定义配置，可以在 VM 中使用 cfg.abc 【可无】
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-rb");
                this.setMap(map);
            }
        };
        // 调整 xml 生成目录演示
        List<FileOutConfig> focList = new ArrayList<FileOutConfig>();
        focList.add(new FileOutConfig("/templates/mapper.xml.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return "D:\\workspace for Maven\\mybatisplustest\\src\\main\\resources" + "/mybatis/mappers/" + tableInfo.getEntityName() + "Mapper.xml";
                //return rb.getString("OutputDirXml")+ "/mybatis/mappers/" + tableInfo.getEntityName() + "Mapper.xml";
            }
        });

        cfg.setFileOutConfigList(focList);

        new AutoGenerator().setGlobalConfig(config)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig).setCfg(cfg)
                .setTemplate(new TemplateConfig().setXml(null))
                .setPackageInfo(
                        new PackageConfig()
                                .setParent(packageName)
                                .setController("controller")
                                .setEntity("entity")
                ).execute();


    }

    private void generateByTables(String packageName, String... tableNames) {
        generateByTables(true, packageName, tableNames);
    }

}
