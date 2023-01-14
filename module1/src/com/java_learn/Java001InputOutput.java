package com.java_learn;

import java.util.Scanner;

public class Java001InputOutput {
    public static void main(String[] args) {
        // 输出 字符串
        String s1 = "hello world";
        System.out.println(s1); // hello world

        String s2 = "你好";
        System.out.println(s2);

        // 输出 字符
        char char1 = 'h';
        System.out.println(char1); // h

        // 输出 int
        int num1 = 13;
        num1 = 15;
        System.out.println(num1); // 15

        num1 += 10;
        System.out.println(num1); // 25

        num1 -= 5;
        System.out.println(num1); // 20

        num1++; // 原有基础上+1
        System.out.println(num1); // 21

        num1--; // 原有基础上-1
        System.out.println(num1); // 20

        // 整数相除 只取商
        System.out.println(10 / 3); // 3

        // 浮点数参加 就有小数
        System.out.println(10 / 3.0); // 3.3333333333333335

        // 浮点数可以除以0  整数可以除以0.0
        System.out.println(10.0 / 0); // Infinity

        // 输出 Long
        long num2 = 2222222222L;
        System.out.println(num2); // 2222222222

        // 输出Double
        double num3 = 0.5743;
        System.out.println(num3); // 0.5743

        // 输出 '
        System.out.println('\''); // '
        System.out.println("'"); // '

        // 输出 “
        System.out.println('"'); // "
        System.out.println("\""); // "

        // 输出 \
        System.out.println("\\"); // \

        // 输出 1换行2
        System.out.println("1\n2"); // 1 换行 2

        // 输出12345Tab4
        System.out.println("12345\t4"); // 12345    4

        // 退1格效果 123退到3之前 然后4把3覆盖
        System.out.println("123\b4"); // 124

        // 输入
        Scanner scanner = new Scanner(System.in);
        String inputString1 = scanner.nextLine();
        int inputNum1 = scanner.nextInt();

        // 输出从控制台输入的
        System.out.println(inputString1);
        System.out.println(inputNum1);
    }
}
