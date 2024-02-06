package com.example.projectbe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.example.projectbe.dto.ServerDto;
import com.example.projectbe.dto.UserDto;
import com.example.projectbe.repository.ServerDao;

@Service
public class ServerServiceImpl implements ServerService {
	@Autowired
	private ServerDao dao;
	
	@Override
	public List<ServerDto> getInfo(int userId) {
		return dao.getList(userId);
	}

}
