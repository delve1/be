package com.example.projectbe;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.projectbe.dto.ServerDto;
import com.example.projectbe.service.ServerService;

@Controller
public class HomeController {
	@Autowired
	ServerService sv_service;

    @GetMapping({ "/", "/home", "/index" })
    public String home(Model model) {
    	
        return "index";
    }
}
