package com.class_example.module4.encapsulation;

public class TestEncapsulation {
    public static void main(String[] args) {
        Car car = new Car();
        // todo private只有本类中才可以访问 这里访问不了Car这个类的私有属性和方法

        // todo 没有修饰符的方法和字段 同包类可以访问
        car.test();
        System.out.println(car.y);

        // todo protected 同包类可以访问
        car.testProtected();
        System.out.println(car.yProtected);
    }
}
