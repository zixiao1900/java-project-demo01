package com.class_example.module4;

import com.class_example.module4.encapsulation.Car;

public class SubCar extends Car {
    // todo protected修饰的字段和方法 可以被跨包继承的子类所访问
    void display() {
        System.out.println(this.yProtected);
        this.testProtected();
    }
}
