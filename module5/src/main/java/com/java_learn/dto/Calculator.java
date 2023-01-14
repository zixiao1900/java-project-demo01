package com.java_learn.dto;

import java.io.Serializable;

// todo 实现一个Java Bean 只存数据  dto = data transfer object
// 1 implement Serializable
// 2 字段全部private  并写get set 方法
// 3 实现有参构造的情况下 一定要实现无参构造
public class Calculator implements Serializable {
    private double p;
    private int m;
    private double yr;

    public Calculator(double p, int m, double yr) {
        this.p = p;
        this.m = m;
        this.yr = yr;
    }

    // todo 在实现有参构造的情况下 实现一个无参构造
    public Calculator() {
    }

    public double getP() {
        return p;
    }

    public void setP(double p) {
        this.p = p;
    }

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }

    public double getYr() {
        return yr;
    }

    public void setYr(double yr) {
        this.yr = yr;
    }
}
