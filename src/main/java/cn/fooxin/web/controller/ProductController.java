package cn.fooxin.web.controller;

import cn.fooxin.web.service.ProductService;
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
@RequestMapping("/product")
public class ProductController extends BaseController {

    @Autowired
    private ProductService productService;

    @GetMapping("/index")
    public ModelAndView index() {
        Map<String, Object> map = new HashMap<>();
        map.put("products", productService.findAll());
        return new ModelAndView("/products/index", map);
    }
}
