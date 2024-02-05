package com.example.projectbe.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projectbe.dto.DummyDto;

import jakarta.annotation.Nullable;

@RestController
public class DummyController {
	@GetMapping("/dummy/hello")
	public String get() {
		return "hello world";
	}
	
	@GetMapping("/dummy/arg")
	public String withArgs(@Nullable String arg) {
		if (arg == null) {
			return "no args"; 
		}
		return arg; 
	}
	
	/**
	 * @param path
	 * @return
	 */
	@GetMapping("/dummy/{path}/path")
	public String path(@PathVariable("path")String path) {
		return path;
	}
	
	@PostMapping("/dummy/post")
	public DummyDto postTest(DummyDto dummy) {
		return dummy;
	}
}
