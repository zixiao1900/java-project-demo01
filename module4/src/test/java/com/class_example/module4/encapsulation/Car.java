package com.class_example.module4.encapsulation;

// todo
//  encapsulation封装
//  public(字段 方法 类):谁都能用
//  protected(字段 方法):只有本类 同包类 子类才能用
//  啥也没有(字段 方法 类):只有同包类才能用(本类可以)
//  private(字段 方法):只有本类才能用
//  private < 默认 < protected < public   字段建议设置为private 想让子类用设置为protected
public class Car {
    private int yPrivate; // 是私有字段
    int y; // 啥也不加
    protected int yProtected; // protected

    public int yPublic;

    void update() {
        // todo 本类可以调用私有字段和方法
        System.out.println(yPrivate);
        testPrivate();

        // todo 啥也不加的 本类同包类都可以
        System.out.println(y);
        test();

        // todo protected 本类子类同包类都可以
        System.out.println(yProtected);
        testProtected();

        // todo public 任何位置都可以访问
        System.out.println(yPublic);
        testPublic();
    }

    private void testPrivate() { // 私有方法 只有本类可以用
        System.out.println("this is testPrivate");
    }

    void test() { // 不修饰 本类 同包类可以用
        System.out.println("this is test");
    }

    protected void testProtected() { // 本类 同包类 跨包子类 可以用
        System.out.println("this is testProtected");
    }

    public void testPublic() { // 哪里都能用
        System.out.println("this is testPublic");
    }
}
