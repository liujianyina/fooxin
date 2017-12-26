package cn.fooxin.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by liujianyin on 2017/12/22.
 */

@Controller
public class RootController {


    @GetMapping({"/", "/index"})
    public String index() {
        return "/index";
    }


}
