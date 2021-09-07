package com.webmangalist.demowebmangalist.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;




@Controller
public class HomeController{

    @GetMapping
    public String index(ModelMap modelMap){
        String[] friends = {"John","Alice","Bob"};
        modelMap.addAttribute("friends", friends);
        return "home";
    }

}