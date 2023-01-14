package com.java_learn.service;

import com.java_learn.dto.Calculator;

import java.text.NumberFormat;

/**
 * 业务逻辑接口
 * 将CalculatorService0, 1, 2中共同的方法 写在这个接口中 然后那几个实现类implement这个接口就行了
 */
public interface CalculatorService {
    // todo 实现类中完全不需要改的方法 用default 实现类中不用再定义
    default String[] createRow(int i, double payment, double payPrinciple, double payInterest, double p) {
        String[] row = new String[]{ // 单行的数组
                (i + 1) + "",
                NumberFormat.getCurrencyInstance().format(payment),
                NumberFormat.getCurrencyInstance().format(payPrinciple),
                NumberFormat.getCurrencyInstance().format(payInterest),
                NumberFormat.getCurrencyInstance().format(p)
        };
        return row;
    }

    // todo 各个实现类中不同的方法 用抽象方法在接口中定义  再在实现类中重写
    String[] cal(Calculator c); // 省略了public abstract

    String[][] details(Calculator c);
}
