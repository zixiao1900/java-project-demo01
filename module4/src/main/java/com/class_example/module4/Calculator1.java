package com.class_example.module4;

import java.text.NumberFormat;

public class Calculator1 extends Calculator{

    // todo 构造器 alt + insert
    public Calculator1(double p, int m, double yr) {
        super(p, m, yr); // 调用父类带参构造
    }

    // todo 实例方法
    @Override
    String[] cal() {
        // 等额本金计算方式
        double mr = yr / 12 / 100;
        double payPrincipal = p / m; // 偿还本金
        double backup = p; // 初始本金
        double payInterestTotal = 0.0;
        for (int i = 0; i < m; i++) {
            double payInterest = p * mr; // 偿还利息
            payInterestTotal += payInterest;
            p -= payPrincipal; // 剩余本金
        }
        return new String[]{
                NumberFormat.getNumberInstance().format(backup + payInterestTotal),
                NumberFormat.getNumberInstance().format(payInterestTotal)
        };
    }
    @Override
    String[][] details() {
        // 等额本金
        double mr = yr / 12 / 100;
        String[][] arr = new String[m][];
        double payPrincipal = p / m;  // 每月偿还本金
        for (int i = 0; i < m; i++) {
            double payInterest = p * mr; // 偿还利息
            p -= payPrincipal; // 剩余本金
            double payment = payPrincipal + payInterest; // 月供
            arr[i] = createRow(i, payment, payPrincipal, payInterest);
        }
        return arr;
    }
}
