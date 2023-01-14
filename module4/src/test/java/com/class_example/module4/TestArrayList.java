package com.class_example.module4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestArrayList {
    public static void main(String[] args) {
        // todo 可以自动扩容ArrayList
        List list = new ArrayList(5);// 初始容量5 默认初始容量10 不够就会扩容
        list.add("a");
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        // 内部封装了扩容逻辑  按1.5倍扩容  5 * 1.5 => 7,  7 * 1.5 => 10
        list.add("f");
        System.out.println(list); // [a, a, b, c, d, e, f]

        list.remove("a"); // 按元素删除 删除第一个匹配的
        System.out.println(list); // [a, b, c, d, e, f]

        list.remove(1); // 按索引删除元素
        System.out.println(list); // [a, c, d, e, f]

        // 创建带有初始化值的List
        List list3 = Arrays.asList("a", "b", "c");
        System.out.println(list3); // [a, b, c]

        ArrayList list9 = new ArrayList(5);
        list9.add(1);
        list9.add(2);
        list.addAll(2, list9); // 从索引位置 将另一个collection元素插入  不给索引就是将list9加载list后面
        System.out.println(list); // [a, c, 1, 2, d, e, f]

        // todo 遍历 增强for
        for (Object e : list) {
            System.out.println(e); // a, b, c, d, e, f
        }

        String[] arr0 = new String[]{"1", "2", "3", "4", "5"};
        for (String s : arr0) {
            System.out.println(s); // 1, 2, 3, 4, 5
        }

        // todo 不加泛型是 Object类型
        ArrayList list1 = new ArrayList(); // Object[]
        list1.add(1); // int -> Integer -> Object
        list1.add(2);
        list1.add(3);
        list1.add(4);

        int sum_ = 0;
        for (Object e : list1) {
            sum_ += (int) e; // 需要转型
        }
        System.out.println(sum_); // 10

        // todo 泛型 用了泛型之后 不能再放其他类型的元素
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.add(4);

        int sum1 = 0;
        for (Integer i : list2) {
            sum1 += i;
        }
        System.out.println(sum1); // 10

    }

    private static void test1() {
        // 数组不能自动扩容  填加一个元素需要 新建一个数组 迁移旧元素 添加新元素
        String[] arr0 = new String[]{"a", "b", "c", "d", "e"};
        String[] arr1 = new String[6]; // 新建数组

        // 打印数组
        System.out.println(Arrays.toString(arr0)); // [a, b, c, d, e]
        System.out.println(Arrays.toString(arr1)); // [null, null, null, null, null, null]

        // 迁移旧元素
        for (int i = 0; i < arr0.length; i++) {
            arr1[i] = arr0[i];
        }
        arr1[5] = "f"; // 添加新元素
        System.out.println(Arrays.toString(arr1)); // [a, b, c, d, e, f]
    }
}
