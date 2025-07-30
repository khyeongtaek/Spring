package org.shark.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/a")
@Controller
public class MvcControllerA {

    @RequestMapping(value = "/list", method = {RequestMethod.GET})
    public String methodA() {
        System.out.println("methodA()");
        return "a/list";
    }

    @RequestMapping("/detail")
    public void methodB() {
        System.out.println("methodB()");
    }

    @RequestMapping("/b/c/d/regist")
    public ModelAndView methodC() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("a/regist");
        return mv;
    }
}