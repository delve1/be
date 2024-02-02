package com.example.projectbe.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.projectbe.dto.ServerDto;

@Repository
public class ServerDaoImpl implements ServerDao {

	@Autowired
	private SqlSession session;
	@Override
	public void insert(ServerDto dto) {
		session.insert("server.insert",dto);
	}

	@Override
	public List<ServerDto> getList(int user_id) {
		
		return session.selectList("server.getList",user_id);
	}

	@Override
	public void delete(int user_id) {
	
	}

}
