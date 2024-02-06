package com.example.projectbe.dto;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Alias("channelDto")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ChannelDto {
	private int channelId;
	private String channelName;
	private ChannelType channelType; 
}
