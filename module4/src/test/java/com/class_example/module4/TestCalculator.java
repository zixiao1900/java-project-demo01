package com.class_example.module4;

import java.util.Arrays;

public class TestCalculator {
    public static void main(String[] args) {
        Calculator0 calculator0 = new Calculator0(100000, 12, 6);
        Calculator1 calculator1 = new Calculator1(100000, 12, 6);
        System.out.println(Arrays.toString(calculator0.cal()));

        System.out.println(Arrays.deepToString(calculator0.details()));


    }
}
