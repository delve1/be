package com.example.projectbe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/user/loginform")
	public String loginform() {
		return "user/loginform";
	}

	@GetMapping("/user/signupform")
	public String signupform() {
		return "user/signupform";
	}

}
