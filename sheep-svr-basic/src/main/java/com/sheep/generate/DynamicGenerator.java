package com.sheep.generate;

import com.sheep.model.MainTemplateConfig;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * 动态文件生成
 */
public class DynamicGenerator {

    public static void main(String[] args) throws IOException, TemplateException {
        File projectAbsolutePath = new File(System.getProperty("user.dir")).getAbsoluteFile();
        System.out.println(projectAbsolutePath);
        String inputPath = new File(projectAbsolutePath,"src/main/resources/templates/MainTemplate.java.ftl").getAbsolutePath();
        // 创建模板对象，加载指定模板
        String outputPath = projectAbsolutePath.getPath()+ File.separator + "MainTemplate.java";

        // 创建数据模型
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setAuthor("ssss");
        // 不使用循环
        mainTemplateConfig.setLoop(true);
        mainTemplateConfig.setOutputText("求和结果：");
        dogenerate(inputPath,outputPath,mainTemplateConfig);

    }

    /**
     * 动态生成
     * @param inputPath 模板文件路径
     * @param outputPath 输出路径
     * @param model 数据模型
     * @throws IOException
     * @throws TemplateException
     */
    public static void dogenerate (String inputPath, String outputPath, Object model) throws IOException, TemplateException {
        // new 出 Configuration 对象，参数为 FreeMarker 版本号
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_32);

        // 指定模板文件所在的路径
        configuration.setDirectoryForTemplateLoading(new File(inputPath).getParentFile());
        // 设置模板文件使用的字符集
        configuration.setDefaultEncoding("utf-8");

        // 创建模板对象，加载指定模板
        String templateName = new File(inputPath).getName();
        Template template = configuration.getTemplate(templateName);

        // 生成文件
        Writer out = new FileWriter(outputPath);
        template.process(model, out);
        // 生成文件后关闭
        out.close();
    }

}
