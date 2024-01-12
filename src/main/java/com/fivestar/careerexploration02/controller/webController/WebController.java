package com.fivestar.careerexploration02.controller.webController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController
{
    @GetMapping("/homepage")
    String hompage()
    {
        return "EnglishProject20240110";
    }

    @GetMapping("/job/police")
    public String police(){
        return "Octn_PoliceOfficer";
    }
    @GetMapping("/about")
    public String about(){
        return "aboutUs";
    }
}



