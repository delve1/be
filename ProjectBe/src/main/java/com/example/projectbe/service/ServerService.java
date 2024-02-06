package com.example.projectbe.service;

import java.util.List;

import org.springframework.ui.Model;

import com.example.projectbe.dto.ServerDto;

public interface ServerService {
	public List<ServerDto> getInfo(int userId);
}
