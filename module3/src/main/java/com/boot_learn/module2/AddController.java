package com.boot_learn.module2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AddController {

    @RequestMapping("/add")  // 和url中add对应  http://localhost:8080/add?..
    @ResponseBody
    int add(int a, int b) {
        return a + b;
    }
}
