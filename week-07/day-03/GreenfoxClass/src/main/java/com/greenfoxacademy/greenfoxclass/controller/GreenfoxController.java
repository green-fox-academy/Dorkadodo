package com.greenfoxacademy.greenfoxclass.controller;

import com.greenfoxacademy.greenfoxclass.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreenfoxController {

    @Autowired
    StudentServiceImpl studentServiceImpl;

    @GetMapping ("/gfa")
    public String gfa (Model model){
        model.addAttribute("studentCount", studentServiceImpl.count());
        return "index";
    }

    @GetMapping ("/gfa/list")
    public String allStudents (Model model){
        model.addAttribute("studentCount", studentServiceImpl.count());
        model.addAttribute("studentList", studentServiceImpl.findAll());
        return "index";
    }

    @GetMapping ("/gfa/add")
    public String addNewStudent(){
        return "addNewStudent";
    }

    @PostMapping("/gfa/save")
    public String saveNewStudent (String newStudent){
        studentServiceImpl.save(newStudent);
        return "redirect:/gfa";
    }

    @GetMapping("/gfa/check")
    public String checkStudent (@RequestParam String nameCheck, Model model){
        model.addAttribute("text", studentServiceImpl.check(nameCheck));
        return "isMember";
    }
}
