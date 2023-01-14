package com.class_example.module4;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CalController {

    /**
     * 对参数的检查
     * @param p 总本金 要求必须大于0
     * @param m 贷款月份 要求必须在1-360之间
     * @param yr 年利率 范围必须在1-36之间
     * @param type 还款类型 只有0和1两种类型
     */
    static void check(double p, int m, double yr, int type) {
        if (p <= 0) {
            throw new IllegalArgumentException("贷款金额必须>0");
        }
        if (m < 1 || m > 360) {
            throw new IllegalArgumentException("贷款月份必须在0-360之间");
        }
        if (yr < 1.0 || yr > 36.0) {
            throw new IllegalArgumentException("年利率必须在 1-36 之间");
        }
        if (type != 0 && type != 1 && type != 2) {
            throw new IllegalArgumentException("type值是不合法的 必须是0或1或2");
        }
    }

    // todo 多态的使用 Calculator是父类  数组里面存着3个子类对象
    static Calculator[] getCalculators(double p, int m, double yr) {
        return new Calculator[] {
                new Calculator0(p, m, yr), // 等额本息
                new Calculator1(p, m, yr), // 等额本金
                new Calculator2(p, m, yr)  // 不计利息
        };
    }


    @RequestMapping("/cal")  // 对应cat_1.html function test1中的  fetch(`http://localhost:8080/cal?p=${p}&m=${m}&yr=${yr}`)
    @ResponseBody
    String[] cal(double p, int m, double yr, int type) {
        check(p, m, yr, type);
        Calculator[] calculators = getCalculators(p, m, yr);
        Calculator c = calculators[type]; // 通过type拿到对应的子类对象 依然用父类的类型
        return c.cal(); // 多态调用 看起来调用父类的cal方法 实际执行对应子类的cal方法
    }

    @RequestMapping("/details")  // fetch(`http://localhost:8080/details?p=${p}&m=${m}&yr=${yr}`)
    @ResponseBody
    String[][] details(double p, int m, double yr, int type) {
        check(p, m, yr, type);
        Calculator[] calculators = getCalculators(p, m, yr);
        Calculator c = calculators[type];
        return c.details();
    }


}
