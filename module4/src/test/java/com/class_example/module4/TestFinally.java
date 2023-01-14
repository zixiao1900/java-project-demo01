package com.class_example.module4;

import java.io.Closeable;
import java.io.IOException;

public class TestFinally {
    public static void main(String[] args) {
        try {
            System.out.println(1);
        } catch (Exception e) {
            System.out.println(2);
        } finally {
            // todo 无论是否发生异常 都会执行finally
            System.out.println(3);
        }
        // 要么打印1 3 要么2 3

        Resource r = new Resource();
        try {
            int i = 1 / 0;
            System.out.println("正常使用资源");
        } catch (Exception e) {
            System.out.println("使用过程中出现异常" + e);
        } finally {
            r.close(); // todo 无论使用过程是否出现异常 都在finally中将资源关闭
        }
        /*
        使用过程中出现异常java.lang.ArithmeticException: / by zero
        释放资源
         */

        System.out.println("****");
        // todo try - with - resource
        // todo 实现了Closeable的资源类 不用自己在finally中写close方法关闭 自动会关闭
        try(Resource1 r1 = new Resource1()) {
            int i = 10 / 0;
            System.out.println("使用资源");
        } catch (Exception e) {
            System.out.println("Closeable" + e);
        }
        /*
        释放资源
        Closeablejava.lang.ArithmeticException: / by zero
         */
    }
}

// 模拟外部资源  文件，数据库 一般会有close方法关闭释放资源  一般写在finally里面 无论出否出现异常 都关闭释放资源
class Resource {
    public void close() {
        System.out.println("释放资源");
    }
}

// 实现Closeable的资源
class Resource1 implements Closeable {

    @Override
    public void close() {
        System.out.println("释放资源");
    }
}
