package com.lzx.mybili.mapper;

import com.lzx.mybili.dto.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper // 这是一个专用于增删改查的接口  // 实现类是由mybatis 和Spring提供 可以通过@Autowired 依赖注入获取实现类对象
public interface StudentMapper {

    // mybatis将查询的每条数据返回Student对象 多个对象封装为List集合返回
    @Select("select id, name from student")
    List<Student> findAll();

    // 根据编号查询学生信息
    @Select("select id, name from student where id=#{id}")
    Student findById(int id); // id=1,2,3

    // 新增学生  替换不止一个时需要用@Param("id")指定替换哪个
    @Insert("insert into student (id, name) values (#{id}, #{name})")
    void insert(@Param("id") int i, @Param("name") String n);

    // 新增另一种方式  传入对象 #{对象属性名称} 大括号里面就是类定义时的属性名称 对映的
    @Insert("insert into student (id, name) values (#{id}, #{name})")
    void insert1(Student student);

    // 修改学生
    @Update("update student set name=#{name} where id=#{id}")
    void update(Student student);

    // 删除学生
    @Delete("delete from student where id=#{id}")
    void delete(int id);

}
