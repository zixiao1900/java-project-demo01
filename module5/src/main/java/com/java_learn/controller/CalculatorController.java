package com.java_learn.controller;

import com.java_learn.dto.Calculator;
import com.java_learn.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // 加在控制器类上
public class CalculatorController { // 控制器对象只有一个

    // todo 这里不想通过if else来判断type选择CalculatorService0,1,2
    // 3种service都实现了CalculatorService接口 可以用接口类型创建数组 用接口多态实现
    // CalculatorController控制器对象只有一个 它的字段也只有一个 如果在cal方法里创建数组 每次调用方法 都会创建新数组
//    private CalculatorService[] arr = new CalculatorService[]{
//            new CalculatorService0(),
//            new CalculatorService1(),
//            new CalculatorService2()
//    };
    @Autowired // todo 依赖注入，根据类型到Spring找对象   实现CalculatorService这个接口的类一定要加@Service
    CalculatorService[] arr; // 根据类名字典顺序自动排的！！！

    // 还款总额  http://localhost:8080/cal?p=${p}&m=${m}&yr=${yr}&type=${type}
    /*
        1. Calculator是Spring框架创建的 过程如下
        前端页面收集数据 /cal?p=100000.0&m=10&yr=6.0&type=0
        2.
            情况1: 有无参构造
                JavaBean类无参构造创建对象 Calculator c = new Calculator();
                调用set方法给字段赋值 c.setM(10); c.setYr(6.0); c.setP(100000.0)


            请款2: 没有无参构造 有有参构造 根据前端传参的名字匹配
                new Calculator(100000.0, 10, 6.0);

        3. Spring调用cal(int type, Calculator c)方法

     */
    @RequestMapping("/cal")
    @ResponseBody
    String[] cal(int type, Calculator c) { // Calculator c 是JavaBean对象 Spring创建的
        check(c.getP(), c.getM(), c.getYr(), type); // 检查输入数据是否符合范围
        CalculatorService service = arr[type]; // 通过type下标拿到service对象
        return service.cal(c); // 创建JavaBean类作为参数
    }

    // 还款详情 http://localhost:8080/details?p=${p}&m=${m}&yr=${yr}&type=${type}
    @RequestMapping("/details")
    @ResponseBody
    String[][] details(double p, int m, double yr, int type) {
        check(p, m, yr, type); // 检查数据是否符合范围
        CalculatorService service = arr[type]; // 通过type下标拿到service对象
        return service.details(new Calculator(p, m, yr));
    }

    // 检查参数的有效性
    static void check(double p, int m, double yr, int type) {
        if (p <= 0) {
            throw new IllegalArgumentException("贷款金额必须>0");
        }
        if (m < 1 || m > 360) {
            throw new IllegalArgumentException("贷款月份必须在1-360之间");
        }
        if (yr < 1.0 || yr > 36.0) {
            throw new IllegalArgumentException("年利率必须在 1-36 之间");
        }
        if (type != 0 && type != 1 && type != 2) {
            throw new IllegalArgumentException("type值是不合法的 必须是0或1或2");
        }
    }
}
