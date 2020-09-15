package com.company.springboot.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

//页面跳转不能使用 @RestController  而是使用@Controller
@Controller
@RequestMapping("/home")
public class HomeController {
    @RequestMapping(value="/home", method=RequestMethod.GET)
//加了@ResponseBody 就是返回字符串了
    public String index(ModelMap map) {
//返回值给页面
        map.addAttribute("name", "小石潭记");
        return "home";
    }

    @RequestMapping(value="/error", method= RequestMethod.GET)
    @ResponseBody
    public String error() {
        return "sorry error";
    }

}
