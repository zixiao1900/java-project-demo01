package com.lzx.mybili;

import com.lzx.mybili.dto.Video;
import com.lzx.mybili.mapper.VideoMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class TestVideoMapper {
    @Autowired
    VideoMapper videoMapper;

    @Test
    public void test1() {
        Video video = videoMapper.findByBv("1");
        System.out.println(video.getBv());
        System.out.println(video.getType());
        System.out.println(video.getCategory());
        System.out.println(video.getTitle());
        System.out.println(video.getCover());
        System.out.println(video.getIntroduction());
        System.out.println(video.getPublishTime());
        System.out.println(video.getTagList());
        System.out.println(video.getPlayList());
    }

    @Test
    public void test2() {
        Video v = new Video();
        v.setType("转发");
        v.setCategory("动漫");
        v.setTitle("海贼王");
        v.setCover("1.png");
        v.setIntroduction("简介...");
        v.setPublishTime(LocalDateTime.now());
        v.setTags("日本_热血_动漫");

        // 取到当前bv最大值 + 1
        int maxBvAddOne = videoMapper.getMaxBv() + 1;
        videoMapper.insert(v, maxBvAddOne + "");
    }
}
