package com.class_example.module4;

/**
 * 接口 - 解决单继承问题
 * 1. 需要放入接口的方法 必须加default关键字(默认方法)
 * 2. default方法只能是public, public可以省略(省略之后还是public)
 *
 * 当前等我文件中 类和接口有TestInterface1, Duck, Swimmable, Flyable 其中只能有一个public
 * public的类必须和文件名同名
 */
public class TestInterface1 {
    public static void main(String[] args) {
        // todo 可以继承多个接口 解决java单继承父类的问题
        Duck d = new Duck();
        d.swim(); // 游泳
        d.fly(); // 飞
    }
}

interface Swimmable {
    default void swim() {
        System.out.println("游泳");
    }
}

interface Flyable {
    default void fly() {
        System.out.println("飞");
    }
}

class Duck implements Swimmable, Flyable {

}