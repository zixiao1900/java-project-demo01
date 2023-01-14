package com.java_learn.service.impl;

import com.java_learn.dto.Calculator;
import com.java_learn.service.CalculatorService;
import org.springframework.stereotype.Service;

import java.text.NumberFormat;

/**
 * 业务逻辑类 - 等额本息方式
 */
@Service // 加在业务逻辑类上
public class CalculatorService0 implements CalculatorService {

    public CalculatorService0() {
        System.out.println("Service0 被创建了");
    }

    @Override
    public String[] cal(Calculator c) { // 传入的参数类型是JavaBean
        // 等额本息计算方式
        double yr = c.getYr(); // JavaBean中获取字段
        int m = c.getM();
        double p = c.getP();
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
    public String[][] details(Calculator c) {
        // 先计算月供
        double yr = c.getYr(); // JavaBean中获取字段
        int m = c.getM();
        double p = c.getP();
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
            // 调用父类实例方法
            arr[i] = createRow(i, payment, payPrinciple, payInterest, p); // 单行的数组替换到二维数组中
        }
        return arr;
    }
}
