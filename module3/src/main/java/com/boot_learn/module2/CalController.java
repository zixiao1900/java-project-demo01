package com.boot_learn.module2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.NumberFormat;

@Controller
public class CalController {

    /**
     * 对参数的检查
     * @param p 总本金 要求必须大于0
     * @param m 贷款月份 要求必须在1-360之间
     * @param yr 年利率 范围必须在1-36之间
     * @param type 还款类型 只有0和1两种类型
     */
    static void check(double p, int m, double yr, int type) {
        if (p <= 0) {
            throw new IllegalArgumentException("贷款金额必须>0");
        }
        if (m < 1 || m > 360) {
            throw new IllegalArgumentException("贷款月份必须在0-360之间");
        }
        if (yr < 1.0 || yr > 36.0) {
            throw new IllegalArgumentException("年利率必须在 1-36 之间");
        }
        if (type != 0 && type != 1) {
            throw new IllegalArgumentException("type值是不合法的 必须是0或1");
        }
    }

    /**
     * 等额本息方式  计算还款总额和利息总额
     *
     * @param p  总本金
     * @param m  还款月数
     * @param yr 贷款年利率
     * @return 还款总额 利息总额
     */
    static String[] cal0(double p, int m, double yr) {
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

    /**
     * 等额本金方式 计算还款总额和利息总额
     *
     * @param p  总本金
     * @param m  还款月数
     * @param yr 贷款年利率
     * @return 还款总额 利息总额
     */
    static String[] cal1(double p, int m, double yr) {
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

    /**
     * 等额本息法 计算每月还款利息 每月偿还本金 每月剩余本金
     *
     * @param p  总本金
     * @param m  还款月数
     * @param yr 年利率
     * @return 多行 每行有当月的偿还本金数 还利息数 已经剩余多少本金未偿还
     */
    static String[][] details0(double p, int m, double yr) {
        // 先计算月供
        double mr = yr / 12 / 100;
        double pow = Math.pow(1 + mr, m);
        double payment = p * mr * pow / (pow - 1); // 月供

        // 定义二维数组   外层长度必须有 m个月
        String[][] arr2 = new String[m][];
        // 外循环 每行代表每个月
        for (int i = 0; i < m; i++) {
            double payInterest = p * mr; // 每月偿还利息
            double payPrinciple = payment - payInterest; // 每月偿还本金
            p -= payPrinciple; // 剩余本金
            String[] row = new String[]{ // 单行的数组
                    (i + 1) + "",
                    NumberFormat.getCurrencyInstance().format(payment),
                    NumberFormat.getCurrencyInstance().format(payPrinciple),
                    NumberFormat.getCurrencyInstance().format(payInterest),
                    NumberFormat.getCurrencyInstance().format(p)

            };
            arr2[i] = row; // 单行的数组替换到二维数组中
        }
        return arr2;
    }

    /**
     * 等额本金法 计算每月还款利息 每月偿还本金 每月剩余本金
     *
     * @param p  总本金
     * @param m  还款月数
     * @param yr 年利率
     * @return 多行 每行有当月的偿还本金数 还利息数 已经剩余多少本金未偿还
     */
    static String[][] details1(double p, int m, double yr) {
        // 等额本金
        double mr = yr / 12 / 100;
        String[][] arr3 = new String[m][];
        double payPrincipal = p / m;  // 每月偿还本金
        for (int i = 0; i < m; i++) {
            double payInterest = p * mr; // 偿还利息
            p -= payPrincipal; // 剩余本金
            double payment = payPrincipal + payInterest; // 月供
            String[] row = new String[]{
                    (i + 1) + "",
                    NumberFormat.getNumberInstance().format(payment),
                    NumberFormat.getNumberInstance().format(payPrincipal),
                    NumberFormat.getNumberInstance().format(payInterest),
                    NumberFormat.getNumberInstance().format(p)
            };
            arr3[i] = row;
        }
        return arr3;
    }

    @RequestMapping("/cal")  // 对应cat_1.html function test1中的  fetch(`http://localhost:8080/cal?p=${p}&m=${m}&yr=${yr}`)
    @ResponseBody
    String[] cal(double p, int m, double yr, int type) {
        check(p, m, yr, type);
        if (type == 0) { // 等额本息法
            return cal0(p, m, yr);
        } else { // 等额本金法
            return cal1(p, m, yr);
        }
    }

    @RequestMapping("/details")  // fetch(`http://localhost:8080/details?p=${p}&m=${m}&yr=${yr}`)
    @ResponseBody
    String[][] details(double p, int m, double yr, int type) {
        check(p, m, yr, type);
        if (type == 0) {
            return details0(p, m, yr); // 等额本息法
        } else {
            return details1(p, m, yr); // 等额本金法
        }
    }


}
