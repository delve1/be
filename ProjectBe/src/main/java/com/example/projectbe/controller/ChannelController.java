package com.example.projectbe.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChannelController {
	
	@GetMapping("/api/server/{channelId}/channel")
	public String getChannel(@PathVariable("channelId")String channelId) {
		return "asdfasd";
	}
}
