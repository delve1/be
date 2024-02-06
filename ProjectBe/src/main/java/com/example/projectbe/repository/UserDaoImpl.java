package com.example.projectbe.repository;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.projectbe.dto.OAuthAttributes;
import com.example.projectbe.dto.Provider;
import com.example.projectbe.dto.UserDto;

//dao 는 @Repository 라는 어노테이션을 이용해서 bean 으로 만든다 
@Repository
public class UserDaoImpl implements UserDao {
	//mybatis 기반으로 동작할때 필요한 객체를 주입 받는다
	@Autowired
	private SqlSession session;
	
	@Override
	public void insert(UserDto dto) {
		session.insert("user.insert", dto);
	}

	@Override
	public void update(UserDto dto) {
	    session.update("user.update", dto);
	}
	
	@Override
	public void updateRefreshToken(String refreshToken) {
		session.update("user.updateRefreshToken", refreshToken);
	}

	@Override
	public UserDto findByUserId(Long userId) {
		return session.selectOne("user.findByUserId", userId);
	}
	
	@Override
	public UserDto findByEmail(String email) {
		return session.selectOne("user.findByEmail", email);
	}
	
	@Override
	public UserDto findByUsername(String username) {
		return session.selectOne("user.findByUsername", username);
	}

	@Override
	public UserDto findByProviderAndSocialId(Provider provider, String socialId) {
		Map<String, Object> pas = new HashMap<String, Object>();
		pas.put("provider", provider);
		pas.put("socialId", socialId);

		return session.selectOne("user.findByProviderAndSocialId", pas);
	}


}