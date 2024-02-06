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
	private int serverId;
	private int userId;
	private String serverName;
	private String regdate;
	private int userTotal;
}
