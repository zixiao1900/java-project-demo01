package com.java_learn;

import java.text.NumberFormat;

public class Java004forLoop {
    public static void main(String[] args) {
        // 打印3次hello
        for (int i = 0; i < 3; i++) {
            System.out.println("hello");
        }

        // 1 - 100 求和
        int sum_ = 0;
        for (int i = 1; i <= 100; i++) {
            sum_ += i;
        }
        System.out.println("1 + 2 + .... + 100 = " + sum_);


        double p = 1000.0; // 本金
        double mr = 1.0; // 月利率
        int m = 2; // 换款月数
        double pow = Math.pow(1 + mr, m);
        double payment = p * mr * pow / (pow - 1); // 每月还款总额

        for (int i = 0; i < m; i++) {
            // 当月偿还利息 = 剩余本金 * 月利率
            double payInterest = p * mr;
            // 当月偿还本金 = 本月还款 - 偿还利息
            double payPrincipal = payment - payInterest;
            // 剩余本金 = 剩余本金 - 偿还本金
            p -= payPrincipal;
            System.out.print("月份: " + (i + 1));
            System.out.println("\t还款总额:" + NumberFormat.getCurrencyInstance().format(payment));
            System.out.println("\t还款本金:" + NumberFormat.getCurrencyInstance().format(payPrincipal));
            System.out.println("\t还款利息:" + NumberFormat.getCurrencyInstance().format(payInterest));

        }
        System.out.println("总还款额:" + NumberFormat.getCurrencyInstance().format(payment * m));
    }
}
