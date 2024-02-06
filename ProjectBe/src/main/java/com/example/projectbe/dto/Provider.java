package com.example.projectbe.dto;

import org.apache.ibatis.type.Alias;

@Alias("provider")
public enum Provider {
	GOOGLE, GITHUB;
}
