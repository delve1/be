package com.example.projectbe.controller;

import java.util.Map;
import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.projectbe.dto.ChannelDto;
import com.example.projectbe.dto.ChannelType;

@RestController
public class ChannelController {
	
	@GetMapping("/api/server/{serverId}/channels")
	public Map<String, List<ChannelDto>> getChannels(@PathVariable String serverId) {
		Map<String, List<ChannelDto>> dummy = Map.ofEntries(
			Map.entry("groupA", List.of(
					new ChannelDto(1, "first channel", ChannelType.text_channel),
					new ChannelDto(2, "second channel", ChannelType.text_channel),
					new ChannelDto(3, "third channel", ChannelType.text_channel)
			)),
			Map.entry("groupB", List.of(
					new ChannelDto(4, "forth channel", ChannelType.text_channel), 
					new ChannelDto(5, "fifth channel", ChannelType.voice_channel)
			)),
			Map.entry("groupC", List.of(
					new ChannelDto(6, "나만의 채널", ChannelType.voice_channel), 
					new ChannelDto(7, "비밀의 채널", ChannelType.voice_channel)
			))
		);				
		return dummy; 
	}

}
