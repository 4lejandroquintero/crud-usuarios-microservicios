package com.microservice.frontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/")
    public String home() {
        return "index"; // Se refiere a templates/index.html
    }

    @GetMapping("/admin")
    public String adminDashboard() {
        return "admin/dashboard"; // Se refiere a templates/admin/dashboard.html
    }
}
