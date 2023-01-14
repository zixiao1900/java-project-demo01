package com.class_example.module4;

// todo 测试 类型转换
public class TestTypeCast {
    public static void main(String[] args) {
        /*
            1. todo 基本类型之间转换规则

                                           <- short <- byte
            double <- float <- long <- int
                                           <- char
            顺箭头 隐式转换(自动)      逆箭头 强制转换
         */
        byte a = 10;
        int b = a; // todo 隐式转换

        int c = 130;
        byte d = (byte) c; // todo 强制转换  可能丢失精度
        System.out.println(d); // -126 超过了精度  Byte最大是127

        /*
            2. todo 包装类型与基本类型之间转换规则  对应的类型可以转换
         */
        int a1 = 20;
        Integer b1 = a1; // int -> Integer

        Integer c1 = new Integer(30);
        int d1 = c1; // Integer -> int

        /*
            3. todo 引用类型之间转换规则
                继承特点
                1. 单继承  子类只能继承一个父类
                2. Object 是其他类型之间或间接的父类型  定义class时，不写extends 此类也是继承Object
                3. 子类与父类，祖先类之间，可以用[is a]的关系表达

                子类到父类(向上转型) 待转换的对象和目标类型之间 要符合is a的关系  隐式转换  使用父类型统一处理子类型
                父类到子类(向下转型) 待转换的对象和目标类型之间 要符合is a的关系  强制转换  将对象还原
         */
        Animal animal1 = new Cat(); // 子类对象 用父类型代表它 隐式转换
        Object obj1 = new Cat();

        // 获取animal真实类型
        System.out.println(animal1.getClass()); // class com.class_example.module4.Cat
        System.out.println(obj1.getClass()); // class com.class_example.module4.Cat

        // 检查对象是否是这个类型
        System.out.println(animal1 instanceof Cat); // true
        System.out.println(animal1 instanceof Dog); // false
        System.out.println(animal1 instanceof Object); // true

        Cat c2 = (Cat) animal1; // 强制转换
//        Dog d2 = (Dog) animal1; // 类型转换异常 ClassCastException
        // 强转之前可以用 instanceof
        if (animal1 instanceof Dog) {
            Dog d2 = (Dog) animal1;
            System.out.println("haha");
        }

        test(new Cat());
        test(new Dog());

        // 数组元素类型用父类  放入的元素可以是任何子类类型
        Animal[] animals = new Animal[] {
                new Cat(), new Dog()
        };
        /*
            4. todo 不属于以上三种的  借助转换方法
            String -> int
         */
        String a4 = "1";
        String b4 = "2";

        System.out.println(Integer.parseInt(a4) + Integer.parseInt(b4)); // 整数加法 3

    }
    static void test(Animal animal) { // todo 参数类型写Animal可以同时传入Cat类型或者Dog类型

    }
}
class Animal extends Object {}
class Cat extends Animal {}
class Dog extends Animal {}
class Appliance {} // 家电类