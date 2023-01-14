package com.boot_learn.module2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// 客户端可以通过查询参数的方式将数据传递给服务器 作为服务器的输入
// http://localhost:8080/hello?arg_name1=arg_value1&arg_name2=arg_value2
// 协议://主机：端口号/路径?查询参数名1=值1&参数名2=值2

@Controller
public class HelloController { // todo 控制器类  处理web程序的输入 输出  一定要有这个注解@Controller

    @RequestMapping("/hello") // http://localhost:8080/hello todo 建立url路径和方法之间的对应关系
    @ResponseBody
        // todo 方法的执行结果作为响应内容 由浏览器输出  传入的参数是url中 问号后面部分
    String hi(String name) {
        return "Hello, " + name;
    }

    @RequestMapping("/bye") // http://localhost:8080/bye
    @ResponseBody
    String bye() {
        return "Bye Bye";
    }
}

// 先运行Module2Application   打开浏览器http://localhost:8080/hello  就能看到Hello, World!
// 重新运行Module2Application   打开浏览器http://localhost:8080/bye 就能看到Bye Bye

// 高端一点的  重新运行Module2Application   打开http://localhost:8080/hello.html
//  1.在文本框中输入alice  点击say hello 按钮  触发了hello.html中 javascript代码的执行
//  2.js中获取到了输入文本框的值alice给到变量n 将查询参数部分拼接成url http://localhost:8080/hello?name=alice
//  3.根据localhost:8080找到本机上的tomcat程序 根据hello路径找到当前文件的hi方法
//  4.根据查询参数name与方法参数name的对应关系 将alice传入hi方法中 结果是Hello, alice
//  5.将返回的信息最终再显示到页面上