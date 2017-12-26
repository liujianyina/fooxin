package cn.fooxin.web.controller;

import cn.fooxin.web.service.CustomerCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liujianyin on 2017/12/26.
 */

@Controller
@RequestMapping("/customer_case")
public class CustomerCaseController extends BaseController {

    @Autowired
    private CustomerCaseService customerCaseService;

    @GetMapping("/index")
    public ModelAndView index() {
        Map<String, Object> map = new HashMap<>();
        map.put("cases", customerCaseService.findAll());
        return new ModelAndView("/customer_case/index", map);
    }

}
