package com.class_example.module4;

import java.text.NumberFormat;

// todo 作为Calculator0, Calculator1的父类
public class Calculator {
    double p;
    int m;
    double yr;

    public Calculator(double p, int m, double yr) {
        this.p = p;
        this.m = m;
        this.yr = yr;
    }
    // todo 实例方法 p调用对象的字段 其他传参
    String[] createRow(int i, double payment, double payPrinciple, double payInterest) {
        String[] row = new String[]{ // 单行的数组
                (i + 1) + "",
                NumberFormat.getCurrencyInstance().format(payment),
                NumberFormat.getCurrencyInstance().format(payPrinciple),
                NumberFormat.getCurrencyInstance().format(payInterest),
                NumberFormat.getCurrencyInstance().format(p)

        };
        return row;
    }

    // todo 利用多态自动判断类型  这里是父类 语法对就行 子类会重写
    String[] cal() {
        return null;
    }

    String[][] details() {
        return null;
    }
}
