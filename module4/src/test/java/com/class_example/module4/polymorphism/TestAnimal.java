package com.class_example.module4.polymorphism;

/**
 * 如果同一个方法执行时，表现除了不同的行为，称此方法具备多态性
 * Poly morphism多态  子类型多态
 *
 * 前提条件
 * 1 用父类型代表子类对象
 * 2 子类和父类得有相同得say方法  方法重写   (对象方法才能重写)
 */
public class TestAnimal {

    static Animal1[] getAnimals() {
        return new Animal1[]{
                new Cat1(),
                new Dog1(),
                new Pig1()
        };
    }

    public static void main(String[] args) {
        Animal1[] animals = getAnimals(); // todo 多态 animals数组中存储的是Animal1的子类 有各自的say()方法
        for (int i = 0; i < animals.length; i++) {
            Animal1 a = animals[i];
            a.say();
        }
    }
}

class Animal1 {
    void say() {
    }
}

class Cat1 extends Animal1 {
    @Override
    void say() {
        System.out.println("喵喵喵");
    }
}

class Pig1 extends Animal1 {
    @Override
    void say() {
        System.out.println("哼哧哼哧");
    }
}

class Dog1 extends Animal1 {
    @Override
    void say() {
        System.out.println("汪汪汪");
    }
}

