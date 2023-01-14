package com.lzx.mybili.controller;

import com.lzx.mybili.dto.Video;
import com.lzx.mybili.service.VideoService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

@Controller
public class PublishController {
    /*
    请求: /publish
    请求数据: json
    {
        "title":"反射",
        "type":"自制",
        "category":"科技->计算机",
        "cover":"封面图片名.png",
        "tags":"面试_java_反射",
        "introduction":"简介...",
        "playList": [
            {"id":"P1","title":"标题1","url":"视频文件名1.mp4","duration":"03:30"},
            {"id":"P2","title":"标题2","url":"视频文件名2.mp4","duration":"04:30"},
        ]
    }
    响应数据：要一个map, key固定为bv 值是bv号
    页面把东西都填好 点击发布之后 会跳转到上传视频的展示页面 包括视频和选集 同时数据库play表和video表都插入了数据 这步都是前端做的
    todo controller调用service, service调用mapper   (service也可能写成接口 用类取实现service接口)
     */

    @Autowired
    private VideoService2 videoService2;

    @RequestMapping("/publish")
    @ResponseBody // 将此处的Map java对象 转为json数据
    public Map<String, String> publish(@RequestBody Video video) {  // @RequestBody  json数据转为Java对象
        String bv = videoService2.publish(video);
        Map<String, String> map = new HashMap<>();
        map.put("bv", bv);
        return map;
    }


}
