package org.example.spring.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class MyController {

    @GetMapping("/")
    public String getInfoForAllEmps() {
        return "view_for_all_employees";
    }

    @GetMapping("/hr_info")
    public String getInfoForHR(@Autowired Principal principal) {

        System.out.println(principal.getName());
        return "view_for_hr";
    }

    @GetMapping("/manager_info")
    public String getInfoForManager() {
        return "view_for_managers";
    }
}
