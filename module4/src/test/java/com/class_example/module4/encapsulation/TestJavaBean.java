package com.class_example.module4.encapsulation;

import java.io.Serializable;

/**
 * JavaBean 规范
 * 1. 字段私有， public 方法来访问私有字段  get set is
 * 2. 最好提供无参构造
 * 3. 最好实现接口 Serializable
 *
 * 属性 有getName方法 或者setName方法  Teacher这个Java Bean有name, married, age属性
 */
public class TestJavaBean {
    public static void main(String[] args) {
        Teacher t = new Teacher("张老师", false);
        // 用get is方法访问私有字段
        System.out.println(t.getName()); // 张老师
        System.out.println(t.isMarried()); // false
        // 用set修改字段值
        t.setMarried(true);
        System.out.println(t.isMarried()); // true
    }
}

class Teacher implements Serializable { // 满足第三条
    private String name;
    private boolean married; // 是否已婚
    private int age;


    // 有参构造
    public Teacher(String name, boolean married) {
        this.name = name;
        this.married = married;
    }

    // todo 在实现有参的构造的情况下 为了满足第二条 再实现一个无参构造
    public Teacher() {
    }

    // get方法 获取私有字段值
    public String getName() { // get后面单词首字母大写
        return this.name;
    }

    // set方法 修改私有字段值
    public void setName(String name) {
        this.name = name;
    }

    public boolean isMarried() { // 获取boolean不用get而用is
        return this.married;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
