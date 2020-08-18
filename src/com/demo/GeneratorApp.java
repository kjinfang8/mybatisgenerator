package com.demo;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GeneratorApp {
        public void generator() throws Exception{
            File configFile = new File("generatorConfig.xml");
            List<String> warnings = new ArrayList<String>();
            ConfigurationParser cp = new ConfigurationParser(warnings);
            Configuration config = cp.parseConfiguration(configFile);
            DefaultShellCallback callback = new DefaultShellCallback(true);//数据回滚
            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
            myBatisGenerator.generate(null);
        }

        public static void main(String[] args) throws Exception {
            try {
                GeneratorApp generatorApp = new GeneratorApp();
                generatorApp.generator();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
}
