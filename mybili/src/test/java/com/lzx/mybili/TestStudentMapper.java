package com.lzx.mybili;

import com.lzx.mybili.dto.Student;
import com.lzx.mybili.mapper.StudentMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest // 加了这个 单元测试类才能用Spring的功能
public class TestStudentMapper {

    @Autowired // 在Spring中查找StudentMapper的对象 找到的话就把实现类对象赋值给studentMapper这个字段
    StudentMapper studentMapper;

    @Test // 测试入口  main方法中没法使用studentMapper
    public void test1() { // 测试查询数据库所有数据方法
        System.out.println(1);
        List<Student> students = studentMapper.findAll();
        for (Student student : students) {
            System.out.println(student.getId() + " " + student.getName());
        }
    }

    @Test // 测试入口
    public void test2() { // 测试根据id查询一条数据的方法
        Student stu = studentMapper.findById(5); // 如果查询id不再数据库中 stu对象返回Null
        if (stu != null) {
            System.out.println(stu.getId() + " " + stu.getName());
        } else {
            System.out.println("id查询不到");
        }

    }

    @Test
    public void test3() { // 测试第一种插入数据的方法
        studentMapper.insert(4, "赵六");
    }

    @Test
    public void test4() { // 测试第二种插入数据的方法
        studentMapper.insert1(new Student(6, "周八"));
    }

    @Test
    public void test5() { // 测试根据id修改name的方法
        studentMapper.update(new Student(1, "张小三"));
    }

    @Test
    public void test6() { // 测试删除为id的学生
        studentMapper.delete(6);
    }

}
