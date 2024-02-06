package com.example.projectbe.handler;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class ChatHandler extends TextWebSocketHandler{
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		String payload = message.getPayload().strip();
		String[] newPayload = payload.split("\\|");
		int first= Integer.parseInt(newPayload[0]);
		String second = newPayload[1];
		int three = Integer.parseInt(newPayload[2]);
		int result=0;
		if(second.equals("plus")) {
			result = first+three;
		}else if(second.equals("minus")) {
			result = first-three;
		}else if(second.equals("mul")) {
			result = first*three;
		}else if(second.equals("div")) {
			result = first/three;
		}
		TextMessage resultMsg =new TextMessage(Integer.toString(result));
		session.sendMessage(resultMsg);
		
	}
}
