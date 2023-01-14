package com.class_example.module4;

public class Phone {
    // todo 字段: 类型+名字
    String brand;
    String memory;
    String size;
    String color;
    double price;
    boolean available; // true上架  false下架

    // todo 有参构造方法 创建对象时被调用 作用是给字段赋予初始值
    // 1. 和类同名  2 不加返回值类型声明
    public Phone(String brand, String memory, String size, String color, double price) {
        this.brand = brand;
        this.memory = memory;
        this.size = size;
        this.color = color;
        this.price = price;
        this.available = true;
    }
}

/*
默认值:
    byte short int long char: 0
    float double: 0.0
    boolean: false
    剩余类型: null
 */