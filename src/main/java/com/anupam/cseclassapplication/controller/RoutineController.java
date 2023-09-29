package com.anupam.cseclassapplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class RoutineController {
    @GetMapping("/")
    public String Routine() {
        return "index.html";
    }
}
