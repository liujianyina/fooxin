package cn.fooxin.web.controller;

import cn.fooxin.web.service.ServiceCenterService;
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
@RequestMapping("/service_center")
public class ServiceCenterController extends BaseController {

    @Autowired
    private ServiceCenterService serviceCenterService;

    @GetMapping("/index")
    public ModelAndView index() {
        Map<String, Object> map = new HashMap<>();
        map.put("serviceCenters", serviceCenterService.findAll());
        return new ModelAndView("/service_center/index", map);
    }


}
