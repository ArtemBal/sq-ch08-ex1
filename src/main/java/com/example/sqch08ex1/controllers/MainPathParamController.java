package com.example.sqch08ex1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainPathParamController {

    @RequestMapping("/homePP/{color}")
    public String home(@PathVariable String color, Model page) {

        page.addAttribute("username", "Artem");
        page.addAttribute("color", color);
        return "home.html";
    }

}
