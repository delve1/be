package com.example.projectbe.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.projectbe.dto.ServerDto;
import com.example.projectbe.service.ServerService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class ServerController {
	@Autowired
	private ServerService service;
		
	@GetMapping("/server/list")
	public List<ServerDto> serverList(int userId) {
		return service.getInfo(userId);
	}	
}
