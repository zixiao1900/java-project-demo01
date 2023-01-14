package com.class_example.module4;

public class TestVariable {
    public static void main(String[] args) {
        // todo 4种变量的区别
        m(10);
        if (true) {
            C c1 = new C(30);
            System.out.println(c1.c);
        }
        System.out.println(C.d);  // 静态对象作用范围比实例对象大

    }

    // 静态方法
    static void m(int a) { // 1.参数变量  作用范围: 方法调用开始，直到方法调用结束
        int b = 20; // 2.局部变量  作用范围: 局部变量定义开始，直到右包围的右花括号结束  必须赋值之后才能使用
    }
}

class C {
    int c; // 3. 对象变量(成员变量)  作用范围 对象创建之后就能用对象对象变量 到对象不能用为止  不需要赋初值也能用 有默认值

    // 构造器
    public C(int c) {
        this.c = c;
    }

    static int d = 40; // 4. 静态变量  作用范围 从类加载到类卸载  所有对象共享的
}
