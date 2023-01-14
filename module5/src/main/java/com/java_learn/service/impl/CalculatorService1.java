package com.java_learn.service.impl;

import com.java_learn.dto.Calculator;
import com.java_learn.service.CalculatorService;
import org.springframework.stereotype.Service;

import java.text.NumberFormat;

/**
 * 业务逻辑类 - 等额本金还款放过是
 */
@Service
public class CalculatorService1 implements CalculatorService {
    public CalculatorService1() {
        System.out.println("Service1 被创建了");
    }

    @Override
    public String[] cal(Calculator c) {
        double yr = c.getYr(); // JavaBean中获取字段
        int m = c.getM();
        double p = c.getP();
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
    public String[][] details(Calculator c) {
        // 等额本金
        double yr = c.getYr(); // JavaBean中获取字段
        int m = c.getM();
        double p = c.getP();
        double mr = yr / 12 / 100;
        String[][] arr = new String[m][];
        double payPrincipal = p / m;  // 每月偿还本金
        for (int i = 0; i < m; i++) {
            double payInterest = p * mr; // 偿还利息
            p -= payPrincipal; // 剩余本金
            double payment = payPrincipal + payInterest; // 月供
            arr[i] = createRow(i, payment, payPrincipal, payInterest, p);
        }
        return arr;
    }
}
