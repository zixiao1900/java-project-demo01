package com.java_learn;

public class Java005Method {
    static int add(int a, int b) { // todo static表示使用直接用类名.方法的方式调用 不是实例化
        return a + b;
    }

    public static void main(String[] args) {
        int res = Java005Method.add(100, 200);
        System.out.println(res);

        // todo 本类的main方法中调本类的静态方法 可以把类名省略
        int res1 = add(10, 20);
        System.out.println(res1);
    }
}
