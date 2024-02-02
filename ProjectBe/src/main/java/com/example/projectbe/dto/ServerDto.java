package com.example.projectbe.dto;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Alias("serverDto")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ServerDto {
	private int server_id;
	private int user_id;
	private String server_name;
	private String regdate;
	private int user_total;
}
