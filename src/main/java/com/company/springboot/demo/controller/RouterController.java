package com.company.springboot.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/router")
public class RouterController {

    @RequestMapping(value = "/updatePwd",method = RequestMethod.POST)
    public String routerForgetPwd(){
      return "updatePwd";
    }
}
