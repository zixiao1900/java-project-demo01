package com.class_example.module4;

public class TestTry {
    public static void main(String[] args) {
        System.out.println(1);
        try {
            test(-1); // 可能有异常的代码  没有异常一切照旧  如果有异常配合catch语句处理异常
        } catch (Exception e) { // 捕捉异常对象 让程序恢复正常流程  todo 实际的异常是否能向上转型为catch中的异常
            System.out.println(e);
        }

        System.out.println(3);
        /*
        1
        java.lang.IllegalArgumentException: 本金必须大于0
        3
         */
    }

    // 可能抛出异常的部分
    public static void test(double p) {
        if (p <= 0.0) {
            throw new IllegalArgumentException("本金必须大于0");
        }
        System.out.println(2);
    }
}
