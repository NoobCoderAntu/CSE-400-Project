package com.anupam.cseclassapplication.controller;

import java.time.Instant;
import java.time.ZoneId;
import org.springframework.ui.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.anupam.cseclassapplication.entity.DatabaseEntity;
import com.anupam.cseclassapplication.repo.EntityRepo;
//import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class RoutineController {
    
    @Autowired
    EntityRepo entityRepo;
    
    @GetMapping("/")
    public String showLogInPage() {
        return "login";
    }

    @GetMapping("/index")
     public ModelAndView index() {
         ModelAndView modelAndView = new ModelAndView("index");

         modelAndView.addObject("RoutineItems", entityRepo.findAll());
         modelAndView.addObject("Today", Instant.now().atZone(ZoneId.systemDefault()).toLocalDate().getDayOfWeek());
         return modelAndView;
     }

    @GetMapping("/home")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("home");

        modelAndView.addObject("RoutineItems", entityRepo.findAll());
        modelAndView.addObject("Today", Instant.now().atZone(ZoneId.systemDefault()).toLocalDate().getDayOfWeek());
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm (@PathVariable("id") long id, Model model) {
         
        DatabaseEntity databaseEntity = entityRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("RoutineItem id : "+id + " not found"));

        model.addAttribute("Routine", databaseEntity);
        return "edit-routine-item";
    }

    @PostMapping("/Routine/{id}")
    public String updateRoutineItem(@PathVariable("id") long id, DatabaseEntity databaseEntity, Model model){
        
        entityRepo.save(databaseEntity);
        return "redirect:/index";

    }
    
}
