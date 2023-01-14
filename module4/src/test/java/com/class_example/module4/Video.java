package com.class_example.module4;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

// 视频JavaBean
// 1 implement Serializable
// 2 字段全部private  并写get set 方法
public class Video implements Serializable {
    private String bv; // 视频编号
    private String title; // 标题
    private LocalDateTime publishTime; // 发布时间
    private String cover; // 视频的封面
    private String introduction; // 简介
    private List<String> tagList; // 多个标签

    private List<Play> playList; // 一个视频中的多个Play对象

    // 当前页面没有用到
    private String type; // 类型 自制的还是转载的
    private String category; // 分区; 生活 游戏 动漫

    public Video(String bv, String title, LocalDateTime publishTime, String cover, String introduction, List<String> tagList, List<Play> playList, String type, String category) {
        this.bv = bv;
        this.title = title;
        this.publishTime = publishTime;
        this.cover = cover;
        this.introduction = introduction;
        this.tagList = tagList;
        this.playList = playList;
        this.type = type;
        this.category = category;
    }

    public String getBv() {
        return bv;
    }

    public void setBv(String bv) {
        this.bv = bv;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(LocalDateTime publishTime) {
        this.publishTime = publishTime;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public List<String> getTagList() {
        return tagList;
    }

    public void setTagList(List<String> tagList) {
        this.tagList = tagList;
    }

    public List<Play> getPlayList() {
        return playList;
    }

    public void setPlayList(List<Play> playList) {
        this.playList = playList;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
