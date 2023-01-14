package com.class_example.module4;

// todo 测试类型系统
public class TestType {
    /*
        1 基本类型 primitive
            byte short int long float double char boolean
        2 引用类型 reference
            String
            byte[]
            int[]
            Phone
            Student
            Calculator
            包装类型
                Byte Short Integer Long Float Double Character Boolean

            todo null 值 引用类型有 基本类型没有  null.方法或者null.字段 就会出现NullPointerException

     */
    public static void main(String[] args) {
        Integer a = new Integer(10); // 包装类型有很多方法 字段等等
        int b = 20; // 基本类型没有方法
        Student s1 = new Student(); // s1.name如果不赋值 默认值是null
//        s1.name = "Alice";
        if (s1.name != null) { // 判断一下 避免NullPointerException
            System.out.println(s1.name.length());
        }
    }
}