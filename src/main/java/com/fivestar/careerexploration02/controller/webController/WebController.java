package com.fivestar.careerexploration02.controller.webController;

import ch.qos.logback.core.rolling.SizeAndTimeBasedRollingPolicy;
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

    @GetMapping("/CustomerService")
    String CustomerService()
    {
        return "CustomerService";
    }

    @GetMapping("/about")
    public String about(){
        return "aboutUs";
    }
    @GetMapping("/cooperation")
    public String cooperation(){
        return "cooperation";
    }

    @GetMapping("/job/police")
    public String police(){
        return "Octn_PoliceOfficer";
    }

    @GetMapping("/job/police_en")
    public String police_en() { return "Octn_PoliceOfficer_en"; }

    @GetMapping("/job/actor")
    public String actor() { return "Octn_Actor"; }

    @GetMapping("/job/chef")
    public String chef() { return "Octn_Chef"; }

    @GetMapping("/job/counselor")
    public String counselor() { return "Octn_Counselor"; }

    @GetMapping("/job/dentist")
    public String dentist() { return "Octn_Dentist";}

    @GetMapping("/job/doctor")
    public String doctor() { return "Octn_Doctor";}

    @GetMapping("/job/fashiondesigner")
    public String fashiondesigner() { return "Octn_FashionDesigner"; }

    @GetMapping("/job/reporter")
    public String reporter() { return "Octn_Reporter"; }

    @GetMapping("/job/teacher")
    public String teacher() { return "Octn_Teacher"; }

    @GetMapping("/job/tourguide")
    public String tourguide() {return "Octn_TourGuide"; }

    @GetMapping("/job/weddingplanner")
    public String weddingplanner() { return "Octn_WeddingPlanner"; }

    @GetMapping("/job/youtuber")
    public String youtuber() { return "Octn_Youtuber"; }
}



