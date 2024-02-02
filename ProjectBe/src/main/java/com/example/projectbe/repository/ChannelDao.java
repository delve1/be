package com.example.projectbe.repository;

import java.util.List;

import com.example.projectbe.dto.ChannelDto;

public interface ChannelDao {
	public void insert(ChannelDto dto);
	public List<ChannelDto> getList(int user_id);
	public void delete(int user_id);
}
