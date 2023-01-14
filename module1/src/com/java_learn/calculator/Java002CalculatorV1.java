package com.java_learn.calculator;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

/**
 * 需求
 * 输入贷款本金 年利率 还款月数   计算按照等额本息方式的每月还款数
 * p为本金  mr为月利率 m为还款月数
 * payment_per_month = p * mr * (1 + mr).pow(m) / ((1 + mr).pow(m) - 1)
 * 查看java doc文档  查看类ctrl + N  查看当前类的方法ctrl + F12
 * 代码中使用的方法 选中方法名 ctrl + Q 可以查看具体方法的定义
 */

public class Java002CalculatorV1 {
    // 结束当前行 让光标进入下一行 或者补全当前行; ctrl + shift + enter
    public static void main(String[] args) {
        // 自动生成变量名和类型 .var 或者alt + enter  // todo 标准输入
        Scanner scanner = new Scanner(System.in);
        // 控制台输入贷款本金 2000000
        System.out.println("请输入本金:");
        double principal = scanner.nextDouble();

        if (principal > 0) { // 本金必须>0
            // 控制台输入年利率 6
            System.out.println("请输入年利率:");
            double yearReturn = scanner.nextDouble();

            if (yearReturn >= 1.0 && yearReturn <= 10.0) { // 年利率>1.0 <10.0

                // 控制台输入还款月数 360
                System.out.println("请输入还款月数:");
                int numMonth = scanner.nextInt();

                if (numMonth >= 1 && numMonth <= 360) {
                    // 计算部分
                    // 计算月利率 // todo 幂运算
                    double mr = yearReturn / 12.0 / 100;
                    double pow1 = Math.pow(1 + mr, numMonth);
                    // 计算还款金额
                    double payment = principal * mr * pow1 / (pow1 - 1);
                    // 转为中国货币格式  // todo 格式化货币
                    String currency = NumberFormat.getCurrencyInstance(Locale.CHINA).format(payment);
                    System.out.println("每月还款: " + currency); // 每月还款: ￥11,991.01

                    for (int i = 0; i < numMonth; i++) {
                        // 当月偿还利息 = 剩余本金 * 月利率
                        double payInterest = principal * mr;
                        // 当月偿还本金 = 本月还款 - 偿还利息
                        double payPrincipal = payment - payInterest;
                        // 剩余本金 = 剩余本金 - 偿还本金
                        principal -= payPrincipal;
                        System.out.print("月份: " + (i + 1));
                        System.out.println("\t还款总额:" + NumberFormat.getCurrencyInstance().format(payment));
                        System.out.println("\t还款本金:" + NumberFormat.getCurrencyInstance().format(payPrincipal));
                        System.out.println("\t还款利息:" + NumberFormat.getCurrencyInstance().format(payInterest));

                    }
                    System.out.println("总还款额:" + NumberFormat.getCurrencyInstance().format(payment * numMonth));

                } else {
                    System.out.println("贷款月数必须是1-360");
                }
            } else {
                System.out.println("yearReturn between 1.0 and 10.0");
            }
        } else {
            System.out.println("本金输入必须>0");
        }
    }
}
