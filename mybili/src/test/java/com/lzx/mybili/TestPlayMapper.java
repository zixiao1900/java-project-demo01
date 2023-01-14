package com.lzx.mybili;

import com.lzx.mybili.dto.Play;
import com.lzx.mybili.mapper.PlayMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalTime;
import java.util.List;

//@SpringBootTest
public class TestPlayMapper {

    @Autowired
    private PlayMapper playMapper;

    @Test
    public void test1() { // 查询play表
        List<Play> playList = playMapper.findByBv("1");
        for (Play play : playList) {
            System.out.println(play.getId() + " " + play.getTitle() + " " + play.getDuration() + " " + play.getUrl());
        }
        System.out.println(playList.size());
    }

    @Test
    public void test2() { // 插入play表
        Play p1 = new Play("P1", "选集1", LocalTime.parse("00:21:10"), "1.mp4");
        Play p2 = new Play("P2", "选集2", LocalTime.parse("00:18:22"), "2.mp4");

        // bv=3的视频有p1, p2两个选集
        playMapper.insert(p1, "3");
        playMapper.insert(p2, "3");
    }
}
