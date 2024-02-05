package com.example.projectbe.dto;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Alias("channelDto")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ChannelDto {
	private int channel_id;
	private String channel_Name;
	private int server_id;
}
