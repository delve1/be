package com.example.projectbe.dto;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Alias("userDto")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
	private Long userId;
	private String socialId;
	private String email;
	private String nickname;
	private String name;
	private String profileImage;
	private String status;
	private String birth;
	private Provider provider;
	private Role role;
	private String refreshToken;
	private String regdate;
}
