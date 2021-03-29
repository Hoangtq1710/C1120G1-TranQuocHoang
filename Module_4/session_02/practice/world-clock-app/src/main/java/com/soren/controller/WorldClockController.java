package com.soren.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.TimeZone;

@Controller
public class WorldClockController {

    @GetMapping("/")
    public String getHome(){
        return "index";
    }

    @GetMapping("/worldClock")
    public String getWorldClock(@RequestParam(defaultValue = "Asia/Ho_Chi_Minh") String city, Model model){
        Date date = new Date();
        TimeZone local = TimeZone.getDefault();
        TimeZone locale = TimeZone.getTimeZone(city);
        long localeTime = date.getTime() + (locale.getRawOffset() - local.getRawOffset());
        date.setTime(localeTime);
        model.addAttribute("city",city);
        model.addAttribute("date",date);
        return "index";
    }
}
