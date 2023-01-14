package com.class_example.module4;

/**
 * 接口特性2 - 多态
 * <p>
 * 方法多态的两个条件
 * 1. 用父类型代表子类对象 或者用接口类型代表实现类对象
 * 2. 子类重写父类方法 或者实现类重写接口方法   注意 子类和试下类  方法访问修饰符 >= 父类和接口 方法访问修饰符
 */
public class TestInterface2 {
    public static void main(String[] args) {
        E[] arr = new E[] {
                new F(),
                new G()
        };
        for (int i = 0; i < arr.length; i++) {
            E e = arr[i];
            e.e(); // todo 多态 分别打印f, g(实现类重写接口方法之后的内容)
        }
    }
}

interface E {
    // todo 默认方法
//    default void e() { // 这里实际是public
//        System.out.println("e");
//    }

    // todo 抽象方法 只有方法声明 没有方法体
    /*
        1. 抽象方法只能是public, public abstract都可以胜率
        2. 为什么抽象方法设计为不需要方法体
        3. 实现类必须重写接口的抽象方法
     */
    void e(); // public abstract省略了
}

class F implements E {
    @Override
    public void e() {
        System.out.println("f");
    }
}

class G implements E {
    @Override
    public void e() {
        System.out.println("g");
    }
}
