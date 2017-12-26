package cn.fooxin.web.controller;

import cn.fooxin.web.service.SolutionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * 解决方案部分
 * <p>
 * Created by liujianyin on 2017/12/26.
 */

@Controller
@RequestMapping("/solutions")
public class SolutionsController extends BaseController {

    @Autowired
    private SolutionsService solutionsService;

    @GetMapping("/index")
    public ModelAndView index() {
        Map<String, Object> map = new HashMap<>();
        map.put("web", solutionsService.findAllByType("web"));
        map.put("pc", solutionsService.findAllByType("pc"));
        map.put("mobile", solutionsService.findAllByType("mobile"));
        map.put("other", solutionsService.findAllByType("other"));
        return new ModelAndView("/solutions/index", map);
    }


}
