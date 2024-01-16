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
    @GetMapping("/about")
    public String about(){
        return "aboutUs";
    }
    @GetMapping("/cooperation")
    public String cooperation(){
        return "cooperation";
    }
    @GetMapping("/CustomerService")
    String CustomerService()
    {
        return "CustomerService";
    }

    @GetMapping("/job/police")
    public String police(){
        return "Octn_PoliceOfficer";
    }
    @GetMapping("/job/Actor")
    public String Actor(){
        return "Octn_Actor";
    }
    @GetMapping("/job/Chef")
    public String Chef(){
        return "Octn_Chef";
    }
    @GetMapping("/job/FashionDesigner")
    public String FashionDesigner(){
        return "Octn_FashionDesigner";
    }
    @GetMapping("/job/Doctor")
    public String Doctor(){
        return "Octn_Doctor";
    }
    @GetMapping("/job/Dentist")
    public String Dentist(){
        return "Octn_Dentist";
    }

}



