
package com.project.test.controller;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

import java.util.Map;

public class ChattingHandshakeInterceptor extends HttpSessionHandshakeInterceptor {

	@Override
	public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
			Map<String, Object> attributes) throws Exception {
		ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) request;
		String group_no = servletRequest.getServletRequest().getParameter("group_no");
		attributes.put("group_no", group_no);
		return super.beforeHandshake(request, response, wsHandler, attributes);
	}

}
