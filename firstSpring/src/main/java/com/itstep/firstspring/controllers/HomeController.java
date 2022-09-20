package com.itstep.firstspring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private int count = 0;
    @GetMapping("/hello")
    public String home(Model model)
    {
        count++;
        model.addAttribute("count", count);

        int [] arr = {3,2,1};
        model.addAttribute("arr", arr);
        return "home";
    }
    @GetMapping("/contact") // Маршрут, по которому будет отвечать данный метод контроллера
    public String contact(){
        return "contact";
    }

}
