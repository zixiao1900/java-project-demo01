package com.class_example.module4;

public class TestThrows {
    public static void main(String[] args) {
        System.out.println(1);
        // todo 处理运行时异常
        try {
            test2(-1);
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println(2);
        // todo 处理编译异常
        try {
            test3(0);
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println(3);
        /*
        1
        java.lang.IllegalArgumentException: 本金必须>0
        2
        java.lang.Exception: 本金必须>0
        3
         */
    }

    public static void test2(double p) {
        if (p <= 0.0) { // todo 运行时异常
            throw new IllegalArgumentException("本金必须>0");
        }
    }

    public static void test3(double p) throws Exception{
        if (p <= 0.0) { // todo 编译时异常
            throw new Exception("本金必须>0");
        }
    }
}
