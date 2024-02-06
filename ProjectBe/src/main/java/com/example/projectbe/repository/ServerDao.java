package com.example.projectbe.repository;

import java.util.List;

import com.example.projectbe.dto.ServerDto;

public interface ServerDao {
	public void insert(ServerDto dto);
	public List<ServerDto> getList(int userId);
	public void delete(int userId);
}
