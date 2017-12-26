package cn.fooxin.web.controller;

import cn.fooxin.web.domain.BaseDomain;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by liujianyin on 2017/12/25.
 */

@Controller
@RequestMapping("/news")
public class NewsController extends BaseDomain {

    @GetMapping("/index")
    public String index() {
        return "/news/index";
    }

}
