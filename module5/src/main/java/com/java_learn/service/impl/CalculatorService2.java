package com.java_learn.service.impl;

import com.java_learn.dto.Calculator;
import com.java_learn.service.CalculatorService;
import org.springframework.stereotype.Service;

import java.text.NumberFormat;

/**
 * 业务逻辑类 - 0息还款方式
 */
@Service
public class CalculatorService2 implements CalculatorService {
    public CalculatorService2() {
        System.out.println("Service2 被创建了");
    }

    @Override
    public String[] cal(Calculator c) { // 传入的参数类型是JavaBean
        // 0利息方式
        double p = c.getP(); // JavaBean中获取字段

        return new String[]{
                NumberFormat.getCurrencyInstance().format(p),
                "0"
        };
    }

    @Override
    public String[][] details(Calculator c) {
        // 先计算月供
        int m = c.getM();         // 先计算月供
        double p = c.getP();

        String[][] arr = new String[m][];
        double payment = p / m;
        for (int i = 0; i < m; i++) {
            p -= payment;
            arr[i] = createRow(i, payment, payment, 0, p);
        }
        return arr;
    }
}
