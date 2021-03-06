package cn.fooxin.web.controller;

import cn.fooxin.web.service.RecruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liujianyin on 2017/12/25.
 */


@Controller
@RequestMapping("/recruit")
public class RecruitController extends BaseController {

    @Autowired
    private RecruitService recruitService;


    @GetMapping("/index")
    public ModelAndView index() {
        Map<String, Object> map = new HashMap<>();
        map.put("recruits", recruitService.findAll());
        return new ModelAndView("/recruit/index", map);
    }


}
