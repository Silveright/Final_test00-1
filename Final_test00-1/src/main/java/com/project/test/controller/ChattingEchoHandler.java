
package com.project.test.controller;
 
import com.fasterxml.jackson.databind.ObjectMapper; 
import com.project.test.domain.Chatting; 
import com.project.test.service.MemberService; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.web.socket.CloseStatus; 
import org.springframework.web.socket.TextMessage; 
import org.springframework.web.socket.WebSocketMessage; 
import org.springframework.web.socket.WebSocketSession; 
import org.springframework.web.socket.handler.TextWebSocketHandler;
  
import java.text.SimpleDateFormat; 
import java.util.ArrayList; 
import java.util.Date; 
import java.util.HashMap; 
import java.util.List; 
import java.util.Map;
 

public class ChattingEchoHandler extends TextWebSocketHandler { 
	// 객체 ==> 주소		Set 중복제거. 
	List<WebSocketSession> sessionList = new ArrayList<WebSocketSession>(); 
	Map<String, String> groupChattingList = new HashMap<String, String>();
	
	@Autowired private MemberService memberservice;
 
	// 클라이언트에서 메세지 도착 시 호출
	@Override 
	public void afterConnectionEstablished(WebSocketSession session) throws Exception { 
		String userid = memberservice.username(session.getPrincipal().getName());
		groupChattingList.put((String) session.getAttributes().get("group_no"),userid); 
		sessionList.add(session); 
		//log.info(userid + "님이 입장하셨습니다"); 
	}
 
	@Override 
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception { 
		String userid = memberservice.username(session.getPrincipal().getName()); 
		ObjectMapper mapper = new ObjectMapper(); SimpleDateFormat sdf = new
		SimpleDateFormat("HH:mm:ss"); String msg = (String) message.getPayload();
		Chatting domain = mapper.readValue(msg, Chatting.class);
		domain.setWriteDate(sdf.format(new Date()));

		String json = mapper.writeValueAsString(domain); 
		for (WebSocketSession s : sessionList) { 
			// if (userid.equals(groupChattingList.get(dto.getGroup_no()))) { 
			s.sendMessage(new TextMessage(json)); 
			// } 
			} 
		}
  
	// 클라이언트 접속 종료 후
	@Override 
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception { 
		String userid = memberservice.username(session.getPrincipal().getName());
		groupChattingList.remove((String) session.getAttributes().get("group_no"),userid); 
		sessionList.remove(session); 
		//log.info(userid + "님이 퇴장하셨습니다"); 
		} 
	}
