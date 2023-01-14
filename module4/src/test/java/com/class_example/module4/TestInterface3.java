package com.class_example.module4;

/**
 * 接口特性3 - 封装
 */
public class TestInterface3 {
    public static void main(String[] args) {
        M m = new N(); // 用接口类型代表实现类对象
        m.m(); // 只能调用接口的方法 不能调用实现类中的方法和字段
    }
}

interface M {
    void m(); // 抽象方法
}

class N implements M {
    public String name;

    @Override
    public void m() {
        System.out.println("m");
    }

    public void n() {
        System.out.println("n");
    }
}