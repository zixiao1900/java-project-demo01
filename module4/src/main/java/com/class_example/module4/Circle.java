package com.class_example.module4;

public class Circle {
    double r;

    // 静态变量 多个实例是共享的  final代表只能赋值一次
    static final double pi = 3.14;

    public Circle(double r) {
        this.r = r;
    }

    double area() {
        return Math.PI * r * r;
    }
}
