package com.anupam.cseclassapplication.controller;

import java.time.Instant;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.anupam.cseclassapplication.repo.EntityRepo;


@Controller
public class RoutineController {
    @Autowired
    EntityRepo entityRepo;
    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("index");

        modelAndView.addObject("RoutineItems", entityRepo.findAll()); 
        modelAndView.addObject("Today", Instant.now().atZone(ZoneId.systemDefault()).toLocalDate().getDayOfWeek());
        return modelAndView;
    }
}
