package com.java_learn.calculator;

import java.text.NumberFormat;
import java.util.Scanner;

/**
 * 需求
 * 输入贷款本金 年利率 还款月数   计算按照等额本息方式的每月还款数
 * p为本金  mr为月利率 m为还款月数
 * payment_per_month = p * mr * (1 + mr).pow(m) / ((1 + mr).pow(m) - 1)
 * 查看java doc文档  查看类ctrl + N  查看当前类的方法ctrl + F12
 * 代码中使用的方法 选中方法名 ctrl + Q 可以查看具体方法的定义
 */

public class Java002CalculatorV2 {
    public static void main(String[] args) {
        double principal = inputAndCheckPrincipal();
        double mr = inputAndCheckMr();
        int numMonth = inputAndCheckNumMonth();
        double payment = calculate(mr, numMonth, principal);
        // todo 调用定义的方法打印每月偿还的本金和利息分别是多少
        printDetails(numMonth, principal, mr, payment);
    }

    /**
     * 控制台输入贷款本金并判断输入是否合理 不合理抛出异常
     *
     * @return 贷款本金
     */
    static double inputAndCheckPrincipal() {
        Scanner scanner = new Scanner(System.in);
        // 控制台输入贷款本金 2000000
        System.out.println("请输入本金:");
        double principal = scanner.nextDouble();
        if (principal <= 0) {
            // todo throw new 异常类型("提示信息")
            throw new IllegalArgumentException("贷款金额必须>0");

        }
        return principal;
    }

    /**
     * 控制台输入年利率并判断输入是否合理 不合理抛出异常
     *
     * @return 月利率
     */
    static double inputAndCheckMr() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入年利率:");
        double yearReturn = scanner.nextDouble();
        if (yearReturn < 1.0 || yearReturn > 10.0) {
            throw new IllegalArgumentException("年化利率必须在1.0-10.0之间");
        }
        return yearReturn / 12.0 / 100;
    }

    /**
     * 控制台输入还款月数并判断是否合理 不合理抛出异常
     *
     * @return 还款月数
     */
    static int inputAndCheckNumMonth() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入还款月数:");
        int numMonth = scanner.nextInt();
        if (numMonth < 1 || numMonth > 360) {
            throw new IllegalArgumentException("还款月数必须在1-360之间");
        }
        return numMonth;
    }

    /**
     * 计算以等额本息的方式计算每月还款金额
     *
     * @param mr        月利率
     * @param numMonth  还款月数
     * @param principal 本金
     * @return 每月还款金额
     */
    static double calculate(double mr, int numMonth, double principal) {
        double pow1 = Math.pow(1 + mr, numMonth);
        // 计算还款金额
        return principal * mr * pow1 / (pow1 - 1);
    }

    /**
     * 打印每个月还本金 利息具体是多少钱
     *
     * @param numMonth  还款月份
     * @param principal 本金
     * @param mr        月利率
     * @param payment   每月还款
     */
    static void printDetails(int numMonth, double principal, double mr, double payment) {
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
    }
}
