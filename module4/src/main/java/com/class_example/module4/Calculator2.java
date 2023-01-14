package com.class_example.module4;

import java.text.NumberFormat;

// 无论借多少钱 多少个月 利息总为0
public class Calculator2 extends Calculator {
    public Calculator2(double p, int m, double yr) {
        super(p, m, yr); // 调用父类有参构造
    }

    @Override
    String[] cal() { // 0还款总额   1还款总利息
        return new String[] {
                NumberFormat.getCurrencyInstance().format(p),
                "0"
        };
    }

    @Override
    String[][] details() {
        String[][] arr = new String[m][];
        double payment = p / m;
        for (int i = 0; i < m; i++) {
            p -= payment;
            arr[i] = createRow(i, payment, payment, 0);
        }
        return arr;
    }
}
