package com.tka.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.tka.Student;
import com.tka.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService service;

    // Show Register Page
    @GetMapping("/register")
    public String showRegister() {
        return "student-register";
    }

    // Register Student
    @PostMapping("/register")
    public String register(@ModelAttribute Student student, Model model) {

        boolean status = service.register(student);

        if (status) {
            return "redirect:/student/login";
        } else {
            model.addAttribute("error", "Registration Failed");
            return "student-register";
        }
    }

    // Show Login Page
    @GetMapping("/login")
    public String showLogin() {
        return "student-login";
    }

    // Login Student
    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        Model model) {

        Student student = service.login(username, password);

        if (student != null) {
            model.addAttribute("student", student);
            return "student-home";
        } else {
            model.addAttribute("error", "Invalid Credentials");
            return "student-login";
        }
    }
}