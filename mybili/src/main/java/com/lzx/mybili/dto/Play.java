package com.lzx.mybili.dto;

import java.time.LocalTime;

// 每一集JavaBean
// 1 implement Serializable
// 2 字段全部private  并写get set 方法
public class Play {
    private String id; // 集号
    private String title; // 每集标题
    private LocalTime duration; // 持续时间
    private String url; // 视频文件路径

    public Play(String id, String title, LocalTime duration, String url) {
        this.id = id;
        this.title = title;
        this.duration = duration;
        this.url = url;
    }

//    public Play() {
//    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalTime getDuration() {
        return duration;
    }

    public void setDuration(LocalTime duration) {
        this.duration = duration;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
