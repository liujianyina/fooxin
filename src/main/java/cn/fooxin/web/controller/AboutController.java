package cn.fooxin.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by liujianyin on 2017/12/26.
 */

@Controller
@RequestMapping("/about")
public class AboutController extends BaseController {

    @GetMapping("/index")
    public String index() {
        return "/about/index";
    }

}
