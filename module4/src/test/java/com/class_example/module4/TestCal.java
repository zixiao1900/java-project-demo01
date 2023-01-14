package com.class_example.module4;


import com.class_example.module4.encapsulation.Car;

import java.text.NumberFormat;

public class TestCal {
    public static void main(String[] args) {
        Cal c1 = new Cal(100000, 24, 4.5);
        double r1 = c1.cal(); // todo 调用对象方法
        System.out.println(NumberFormat.getCurrencyInstance().format(r1));

        double r1Static = Cal.calStatic(100000, 24, 4.5); // todo 调用静态方法
        System.out.println(NumberFormat.getCurrencyInstance().format(r1Static));

        Cal c2 = new Cal(100000, 12, 6.0);
        double r2 = c2.cal(); // 调用对象方法
        System.out.println(NumberFormat.getCurrencyInstance().format(r2));

    }

}
