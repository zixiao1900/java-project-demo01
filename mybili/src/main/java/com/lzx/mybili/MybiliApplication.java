package com.lzx.mybili;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*
1 实现WebMvcConfigurer  2重写addResourceHandlers  就可以把url路径和磁盘路径做映射
路径不再从resources/static下面找 而是从映射的磁盘路径找
 */

@SpringBootApplication // 支持 SpringBoot 功能的应用程序
public class MybiliApplication implements WebMvcConfigurer { // 1 todo 实现WebMvcConfigurer为了关联磁盘的数据到页面

    public static void main(String[] args) {
        SpringApplication.run(MybiliApplication.class, args);
    }

    // todo 2 把url路径和磁盘路径做一个映射
    // 原来 http://localhost:8080/play/xxx => resources/static/play/
    // 映射后 http://localhost:8080/play/xxx => D:\JavaCodes\java-project-demo01\video\
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 实现这个方法 play路径找的就不是static路径下的文件了 而是去磁盘路径中找文件
        // url路径                     磁盘路径
        registry.addResourceHandler("/play/**").addResourceLocations("file:video\\");

        // 图片去img目录下找
        registry.addResourceHandler("/img/**").addResourceLocations("file:" + imgPath);
    }

    @Value("${img-path}") // 根据application.properties的key 找到value传给imgPath
    private String imgPath;
}
