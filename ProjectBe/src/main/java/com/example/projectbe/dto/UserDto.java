package com.example.projectbe.dto;

import org.apache.ibatis.type.Alias;
import org.springframework.web.multipart.MultipartFile;

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
	private int id;
	private String email;
	private String nickname;
	private String phoneNumber;
	private String name;
	private MultipartFile profileImage;
	private String status;
	private String regdate;
	private String birth;
}

