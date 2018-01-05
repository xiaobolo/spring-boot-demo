package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@Controller
public class HelloController {

    @Autowired
    private ApplicationProperties applicationProperties;

    private int loginId = 0;

    private String[] users = {"xiaobolo", "hermione", "emily", "pandora"};

    private Date date;

    @RequestMapping("/")
    public String index(ModelMap map) {

        date = new Date();

        // 加入一个属性，用来在模板中读取
        map.addAttribute("name", applicationProperties.getName());
        map.addAttribute("title", applicationProperties.getTitle());
        map.addAttribute("loginId", loginId);
        map.addAttribute("users", users);
        map.addAttribute("date", date);
        // return模板文件的名称，对应src/main/resources/templates/index.html
        return "index";
    }

}