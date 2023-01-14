package com.lzx.mybili.service;

import com.lzx.mybili.dto.Play;
import com.lzx.mybili.dto.Video;
import com.lzx.mybili.mapper.PlayMapper;
import com.lzx.mybili.mapper.VideoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 从mysql数据库中查询视频信息 返回为JavaBean对象
 */

@Service
public class VideoService2 {

    @Autowired
    private VideoMapper videoMapper;

    @Autowired
    private PlayMapper playMapper;

    // 通过bv 从数据库中查找video信息
    public Video find(String bv) {
        Video video = videoMapper.findByBv(bv); // 没有playList信息  数据库中没有playList信息 此时这个字段是null  这里的tags也用了小技巧
        // 数据库的字段是tags string类型 Video JavaBean中是List<String> tagList 无法直接通过VideoMapper映射
        // 解决方法：将Video JavaBean加一个tags字段 将数据库中的信息先映射过来 再重写tagList的get方法 将刚刚获取数据库并映射到tags字段的信息做处理 写在tagList的get方法里
        if (video == null) {
            return null;
        }
        // 数据库中查playList信息
        List<Play> playList = playMapper.findByBv(bv);
        video.setPlayList(playList);
        return video;
    }

    // 发布视频
    public String publish(Video video) {
        // 0 发布时间是当前时间  设置发布时间
        video.setPublishTime(LocalDateTime.now());

        // 1. 向video表插入视频
        // 通过上传页面处理的信息 会成为一个json格式title, type, category, cover, tags, introduction, playlist[]信息都有 没有bv
        int maxBvAddOne = videoMapper.getMaxBv() + 1; // 算出当前bv号 最大bv号加1
        String bv = maxBvAddOne + "";
        videoMapper.insert(video, bv);

        // 2. 向play表插入视频选集
        for (Play play : video.getPlayList()) {
            playMapper.insert(play, bv);
        }
        return bv;
    }
}
