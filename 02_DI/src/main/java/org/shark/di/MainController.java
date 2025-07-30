package org.shark.di;

import org.shark.di.service.DIService;
import org.shark.di.service.DIServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @Autowired
    private DIService diService;

    @RequestMapping(value ="/")
    public String main(){
        diService.serviceMethod();
        return "main";
    }
}
