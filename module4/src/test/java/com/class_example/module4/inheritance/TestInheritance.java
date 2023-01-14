package com.class_example.module4.inheritance;

// todo 测试继承
public class TestInheritance {
    public static void main(String[] args) {
        B b = new B("tom");
        System.out.println(b.name); // tom
        b.test(); // 父类的测试方法

        D d = new D("alice");
        System.out.println(d.name); // alice
        d.test(); // 父类的测试方法

        // 父类的静态方法调用 子类实例虽然可以调用 一般还是用定义静态的类名.静态方法调用
        A.printWord("hello world"); // hello world
    }
}

class A { // 父类
    String name;
    // 父类带参构造
    public A(String name) {
        this.name = name;
    }

    void test() {
        System.out.println("父类的测试方法");
    }

    static void printWord(String word) {
        System.out.println(word);
    }
}

class B extends A { // 子类  可以继承字段和方法  不能继承构造方法
    // todo 子类构造方法
    B(String name) {
        // 调用父类带参构造
        super(name);
    }
}

class D extends A {
    public D(String name) {
        super(name);
    } // 子类

}
