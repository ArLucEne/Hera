package com.demin.hera.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by  Domain
 * on 2019/6/9 9:43;
 */

@RestController
public class testController {
    @RequestMapping("/shopTest")
    public String test(){
        return "hello, this is shop";
    }
}
