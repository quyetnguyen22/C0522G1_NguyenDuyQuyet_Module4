package com.localtime.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.TimeZone;

@Controller
public class TimeController {
    @GetMapping("/zone")
    public String timeZone(){
        return "/timeZone";
    }

    @GetMapping("/localTime")
    public String zoneTime(Model model, @RequestParam(name = "city", required = false, defaultValue = "Asia/Ho_Chi_Minh") String city) {
        Date date = new Date();
        TimeZone timeZone = TimeZone.getDefault();
        TimeZone local = TimeZone.getTimeZone(city);
        long localTime = date.getTime() + (local.getRawOffset() - timeZone.getRawOffset());
        date.setTime(localTime);

        model.addAttribute("city",city);
        model.addAttribute("date",date);
        return "/timeZone";
    }
}
