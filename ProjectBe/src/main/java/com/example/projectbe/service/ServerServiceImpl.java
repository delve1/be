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
	ServerDao dao;
	@Override
	public void getInfo(Model model,int user_id) {
		List<ServerDto> list=dao.getList(user_id);
		model.addAttribute("serverList",list);
		System.out.println("여기 서비스");
		
	}

}
