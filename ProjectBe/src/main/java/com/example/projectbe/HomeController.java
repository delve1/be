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
    	sv_service.getInfo(model, 41);
    	System.out.println("여기 컨트롤러");
        List<ServerDto> serverList = (List<ServerDto>) model.getAttribute("serverList");
        for (ServerDto server : serverList) {
            System.out.println("Server Name: " + server.getServer_name());
        }
        return "index";
    }
    
 
}
