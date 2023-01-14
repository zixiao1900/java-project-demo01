package com.class_example.module4;

public class Cal {
    // todo 字段
    double p;
    int m;
    double yr;

    // todo 带参构造方法
    public Cal(double p, int m, double yr) {
        this.p = p;
        this.m = m;
        this.yr = yr;
    }

    // todo 对象方法
    /**
     * 计算等额本息还款数  可以直接使用实例字段
     * @return
     */
    double cal() {
        double mr = yr / 100 / 12;
        double pow = Math.pow(1 + mr, m);
        return m * p * mr * pow / (pow - 1);
    }

    // todo 静态方法 参数全部用传进入的
    static double calStatic(double p, int m, double yr) {
        double mr = yr / 100 / 12;
        double pow = Math.pow(1 + mr, m);
        return m * p * mr * pow / (pow - 1);
    }
}
