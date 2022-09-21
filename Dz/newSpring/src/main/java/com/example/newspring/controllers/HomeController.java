package com.example.newspring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/elements")
    public String elements(){
        return "elements";
    }
    @GetMapping("/generic")
    public String generic(){
        return "generic";
    }
}
