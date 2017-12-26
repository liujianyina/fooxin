package cn.fooxin.web.controller;

import cn.fooxin.web.domain.AjaxResult;
import cn.fooxin.web.domain.Recruit;
import cn.fooxin.web.service.RecruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by liujianyin on 2017/12/25.
 */


@Controller
@RequestMapping("/recruit")
public class RecruitController extends BaseController {

    @Autowired
    private RecruitService recruitService;


    @GetMapping("/index")
    public String index() {
        return "/recruit/index";
    }

    @ResponseBody
    @PostMapping("/recruit_list")
    public AjaxResult queryPage(int page, int size) {
        Page<Recruit> recruits = recruitService.queryPage(page, size);
        return AjaxResult.success(recruits.getTotalElements(), recruits.getContent());
    }


}
