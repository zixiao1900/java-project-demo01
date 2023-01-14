package com.lzx.mybili.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/*
功能1：
    选中mp4视频文件，分块上传至服务器
    服务器在上传过程中返回进度(进度分块/总分块%)
    所有分块上传完毕后，服务器合并当前文件

上传分块：
    请求： /upload路径
    请求数据：
        i第几块，从1开始
        chunks总快数
        data分块数据
        url视频文件名
    响应数据：
        要一个map, key是url视频文件名，value是上传进度，以百分比表示

合并分块
    请求: /finish
    请求数据：
        chunks总块数
        url视频文件名
    响应数据: 无


上传封面
    请求: /uploadCover
    请求数据:
        data封面图片数据
        cover图片名
    响应数据:
        要一个map, key固定为cover, 值是图片名
    效果 上传视频的时候 点击视频 会将视频的第一帧图片作为封面上传到img目录下
 */

@Controller
public class UploadController {

    @Value("${upload-video-path}") // application.properties中key为upload-video-path 对应的value赋值给videoUploadPath
    private String videoUploadPath;

    // 处理上传分块  一次最多上传8m 每上传一个文件可能被调用多次
    @RequestMapping("/upload")
    @ResponseBody
    public Map<String, String> upload(int i, int chunks, MultipartFile data, String url) throws IOException { // MultipartFile专用于上传二进制数据的类型
        System.out.println(i + "/" + chunks + " " + url);
        // 将分块的文件存在服务器上
        data.transferTo(Paths.get(videoUploadPath, url + ".part" + i));

        // 返回map
        Map<String, String> map = new HashMap<>();
        map.put(url, (i * 100.0 / chunks) + "%");
        return map; // 为啥返回映射类型 因为需求就是这么定的
    }

    // 将upload上传的分块文件 还原为整个存在服务器上
    @RequestMapping("/finish")
    @ResponseBody
    public void finish(int chunks, String url) throws IOException {
        // 将前缀相同的分块文件 合并为1个整文件
        // FileOutputStream 文件输出流(作用: 创建新文件并写入内容)
        try (FileOutputStream os = new FileOutputStream(videoUploadPath + url)) {
            for (int i = 1; i <= chunks; i++) {
                Path part = Paths.get(videoUploadPath, url + ".part" + i);
                // 参数1 原始文件  参数2 目标文件
                Files.copy(part, os);
                // 删除分块文件
//                part.toFile().delete();
            }
        }
        // finally
    }

    @RequestMapping("/uploadCover")
    @ResponseBody
    public Map<String, String> uploadCover(MultipartFile data, String cover) throws IOException {
        // 临时文件传入正式文件
        data.transferTo(Paths.get("img", cover));

        // 返回{"cover", cover路径}
        Map<String, String> map = new HashMap<>();
        map.put("cover", cover);
        return map;
    }
}
