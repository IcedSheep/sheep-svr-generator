package com.sheep.generate;

import cn.hutool.core.io.FileUtil;

import java.io.File;

/**
 * 静态文件生成
 */
public class StaticGenerator {

    public static void main(String[] args) {

        // 文件的输出路径
        String outputPath = System.getProperty("user.dir");
        // D:\code\sheep-svr-generator/sheep-svr-demo
        File parentFile = new File(outputPath).getParentFile();
        // 要复制文件的路径
        String inputPath = new File(parentFile, "sheep-svr-demo/acm-template").getAbsolutePath();
        System.out.println(outputPath);
        System.out.println(inputPath);
        // 文件拷贝
        FileUtil.copy(inputPath,outputPath,false);
    }

    public void copyFileByHutool (String inputPath, String outputPath) {
        FileUtil.copy(inputPath,outputPath,false);
    }
}
