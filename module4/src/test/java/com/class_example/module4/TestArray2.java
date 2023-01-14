package com.class_example.module4;

public class TestArray2 {
    public static void main(String[] args) {
        // 1. 数组长度
        String[] arr1 = new String[]{"北京", "上海", "深圳"};
        System.out.println("数组的长度是:" + arr1.length);

        // 2. 数组越界  ArrayIndexOutOfBoundsException数组索引越界异常
//        System.out.println(arr1[2]);

        // 3.遍历数组
        for (int i = 0; i < arr1.length; i++) {
            System.out.println(arr1[i]);
        }

        // 4.增强for
        for (String s: arr1) {
            System.out.println(s);
        }

        // 5. 默认值
        String[] arr2 = new String[3];  // todo 字符串数组 默认是null
        for (String s: arr2) {
            System.out.println(s); // null
        }
        // todo 整数数组默认0 double数组默认0.0 boolean数组默认false
        int[] arr3 = new int[3];
        for (int i: arr3) {
            System.out.println(i);
        }

        // 6 二维数组
        // 赋值
        int[][] arr4 = new int[3][];
        for (int i = 0; i < arr4.length; i++) {
            int[] row = new int[] {
                    1, 2, 3, 4
            };
            arr4[i] = row;
        }

        // 遍历打印
        for (int i = 0; i < arr4.length; i++) {
            for (int j = 0; j < arr4[i].length; j++) {
                System.out.print(arr4[i][j]);
            }
            System.out.println();
        }
    }
}
