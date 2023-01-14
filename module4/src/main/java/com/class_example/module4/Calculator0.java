package com.class_example.module4;

import java.text.NumberFormat;

/**
 * 等额本息方式的计算器
 */
public class Calculator0 extends Calculator{

    // todo 带参构造其alt + insert
    public Calculator0(double p, int m, double yr) {
        super(p, m, yr); // 调用父类带参构造
    }

    // todo 对象方法 运行的数据如果对象字段中有就不用传参 没有再进行传参
    @Override
    String[] cal() {
        // 等额本息计算方式
        double mr = yr / 12 / 100;
        double pow = Math.pow(1 + mr, m);
        double payment = p * mr * pow / (pow - 1);
        // 数组 [0]还款总额  [1]利息总额
        return new String[]{
                NumberFormat.getCurrencyInstance().format(payment * m),
                NumberFormat.getCurrencyInstance().format(payment * m - p)
        };
    }
    @Override
    String[][] details() {
        // 先计算月供
        double mr = yr / 12 / 100;
        double pow = Math.pow(1 + mr, m);
        double payment = p * mr * pow / (pow - 1); // 月供

        // 定义二维数组   外层长度必须有 m个月
        String[][] arr = new String[m][];
        // 外循环 每行代表每个月
        for (int i = 0; i < m; i++) {
            double payInterest = p * mr; // 每月偿还利息
            double payPrinciple = payment - payInterest; // 每月偿还本金
            p -= payPrinciple; // 剩余本金
            // todo 调用父类实例方法
            arr[i] = createRow(i, payment, payPrinciple, payInterest); // 单行的数组替换到二维数组中
        }
        return arr;
    }
}
