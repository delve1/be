package com.example.projectbe.dto;

import org.apache.ibatis.type.Alias;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Alias("role")
@Getter
@RequiredArgsConstructor
public enum Role {
	ADMIN("ROLE_ADMIN"), USER("ROLE_USER"), GUEST("ROLE_GUEST");
	
	private final String key;
}
