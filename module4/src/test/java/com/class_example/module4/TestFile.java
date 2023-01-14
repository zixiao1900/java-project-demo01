package com.class_example.module4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * 测试文件的读取
 */
public class TestFile {
    public static void main(String[] args) throws IOException {
        // Files 包含都是跟文件操作相关的方法(读取文件内容，拷贝文件，删除文件)
        // Path 代表的室文件存储路径
        // Files.readAllLines  读取文件中的所有行
        List<String> data = Files.readAllLines(Paths.get("data/p.csv"));//编译时异常方法后面throws IOException
        for (String line : data) {
            // line就是读到的每一行数据
//            System.out.println(line);
            // bv编号, type自制还是转载, category, title, cover封面图片, introduction, publishTime, tagList
            String[] s = line.split(","); // 英文逗号分割  中文逗号不分割
            String[] tags = s[7].split("_");
            System.out.println(s[0] + " " + s[6] + " " + tags);
            // 封装Video对象
            new Video(s[0], s[3], LocalDateTime.parse(s[6]), s[4], s[5], Arrays.asList(tags), Arrays.asList(), s[1], s[2]);
        }


    }
}
