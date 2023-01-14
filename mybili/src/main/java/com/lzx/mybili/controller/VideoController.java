package com.lzx.mybili.controller;

import com.lzx.mybili.dto.Play;
import com.lzx.mybili.dto.Video;
import com.lzx.mybili.service.VideoService1;
import com.lzx.mybili.service.VideoService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

@Controller
public class VideoController {

    // 路径参数

    // 1. @RequestMapping("/video/{bv}")
    // 2. @PathVariable String bv  @PathVariable表示方法参数 从路径中获取bv这个参数
    @RequestMapping("/video/{bv}")
    @ResponseBody
    public Video t(@PathVariable String bv) { // t这个方法名无所谓  @PathVariable表示该方法参数从路径中获得 bv这个方法参数是从路径中获取的
        // todo 方法3 这个方式 bv在参数里 一个方法搞定 并且通过读文件数据不用写在内存里  逻辑也不用写在controller里
//        return videoService1.find(bv);

        // todo 方法4 这个方式 bv在参数里 通过查数据建库 返回video 比查文件更好 最终的方法
        return videoService2.find(bv);

        // todo 方法2 这个方式 可以将请求bv写在参数里 可以一个方法搞定 但是数据都是写在内存里的 数据应该是在磁盘文件中 而且业务逻辑不要写在controller里面
//        if (bv.equals("1")) {
//            List<Play> plays = Arrays.asList(
//                    new Play("P1", "二分查找演示", LocalTime.parse("00:05:46"), "1_1.mp4"),
//                    new Play("P2", "二分查找实现", LocalTime.parse("00:06:47"), "1_2.mp4")
//            );
//            return new Video("1", "面试专题-基础篇", LocalDateTime.now(), "1.png", "祝你面试游刃有余！",
//                    Arrays.asList("面试", "Java", "计算机技术"), plays, "自制", "科技-计算机技术");
//        }
//        if (bv.equals("2")) {
//            List<Play> plays = Arrays.asList(
//                    new Play("P1", "Java中的线程状态", LocalTime.parse("00:09:45"), "2_1.mp4"),
//                    new Play("P2", "代码演示1", LocalTime.parse("00:07:05"), "2_2.mp4"),
//                    new Play("P3", "代码演示2", LocalTime.parse("00:05:01"), "2_3.mp4")
//            );
//            return new Video("2", "面试专题-并发篇", LocalDateTime.now(), "2.png", "祝你面试游刃有余！",
//                    Arrays.asList("面试", "Java", "计算机技术"), plays, "自制", "科技-计算机技术");
//        }
//        return null;
    }

    // todo 如果VideoService1是接口 那么所有实现了这个接口的类并且加了@Service的类都会注入 按照字典顺序
    // todo 如果VideoService1是service类(一般不会用类继承) 那么就直接注入加了这个Service的类
//    @Autowired  // todo 依赖注入，根据类型到Spring找对象
//    private VideoService1 videoService1;
    @Autowired
    private VideoService1 videoService1;

    @Autowired
    private VideoService2 videoService2;


    // todo 方法1 这种方式比较原始 每个url请求都要单独写一个方法 比较拉跨 而且所有的信息都是在内存里创建的
//    @RequestMapping("/video/1")
//    @ResponseBody
//    public Video t1() {
//        // 每个视频对应的集数  作为Video的参数
//        List<Play> plays = Arrays.asList(
//                new Play("P1", "二分查找演示", LocalTime.parse("00:05:46"), "1_1.mp4"),
//                new Play("P2", "二分查找实现", LocalTime.parse("00:06:47"), "1_2.mp4")
//        );
//        return new Video("1", "面试专题-基础篇", LocalDateTime.now(), "1.png", "祝你面试游刃有余！",
//                Arrays.asList("面试", "Java", "计算机技术"), plays, "自制", "科技-计算机技术");
//    }
//
//    @RequestMapping("/video/2")
//    @ResponseBody
//    public Video t2() {
//        List<Play> plays = Arrays.asList(
//                new Play("P1", "Java中的线程状态", LocalTime.parse("00:09:45"), "2_1.mp4"),
//                new Play("P2", "代码演示1", LocalTime.parse("00:07:05"), "2_2.mp4"),
//                new Play("P3", "代码演示2", LocalTime.parse("00:05:01"), "2_3.mp4")
//        );
//        return new Video("2", "面试专题-并发篇", LocalDateTime.now(), "2.png", "祝你面试游刃有余！",
//                Arrays.asList("面试", "Java", "计算机技术"), plays, "自制", "科技-计算机技术");
//
//    }
}
