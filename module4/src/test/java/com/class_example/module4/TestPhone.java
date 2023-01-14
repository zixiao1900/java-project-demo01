package com.class_example.module4;

public class TestPhone {
    public static void main(String[] args) {
        // 创建对象
        Phone p1 = new Phone("苹果", "128G", "6.1寸", "星光色", 5799.0);

        Phone p2 = new Phone("小米", "8G", "6.5寸", "金色", 799.0);

        Phone p3 = new Phone("华为", "64G", "6.3寸", "黑色", 4799.0);

        // 获取实例对象字段值
        System.out.println(p1.color); // 星光色
        System.out.println(p1.price); // 5799.0
        System.out.println(p1.available); // true

        // 修改实例对象字段值
        p1.price = 3000.0;
        System.out.println(p1.price); // 3000.0


    }
}
