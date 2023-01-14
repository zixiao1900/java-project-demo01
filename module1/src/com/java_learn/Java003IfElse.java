package com.java_learn;

import java.util.Scanner;

public class Java003IfElse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = 1;
        int b = -1;
        if (a > 0) {
            System.out.println("a > 0");
            if (b > 0) {
                System.out.println("b > 0");
            } else {
                System.out.println("b <= 0");
            }
        } else {
            System.out.println("a <= 0");
        }


        // 效果同上
        if (a <= 0) {
            System.out.println("a <= 0");
            return;
        }
        System.out.println("a > 0");
        if (b <= 0) {
            System.out.println("b <= 0");
            return;
        }
        System.out.println("b > 0");


    }
}
