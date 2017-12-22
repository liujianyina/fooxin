package cn.fooxin.web.controller;

import cn.fooxin.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by liujianyin on 2017/12/22.
 */

@Controller
public class RootController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @GetMapping("/test")
    public String test() {
        userService.findOne(1L);
        return "123456";
    }

}
