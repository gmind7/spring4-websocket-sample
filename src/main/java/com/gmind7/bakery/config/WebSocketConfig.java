package com.gmind7.bakery.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.handler.PerConnectionWebSocketHandler;

import com.gmind7.bakery.websocket.DefaultEchoService;
import com.gmind7.bakery.websocket.EchoWebSocketHandler;
import com.gmind7.bakery.websocket.SnakeWebSocketHandler;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {

		registry.addHandler(echoWebSocketHandler(), "/echo", "/echo-issue4");
		registry.addHandler(snakeWebSocketHandler(), "/snake");

		registry.addHandler(echoWebSocketHandler(), "/sockjs/echo").withSockJS();
		registry.addHandler(echoWebSocketHandler(), "/sockjs/echo-issue4").withSockJS().setHttpMessageCacheSize(20000);

		registry.addHandler(snakeWebSocketHandler(), "/sockjs/snake").withSockJS();
	}

	@Bean
	public WebSocketHandler echoWebSocketHandler() {
		return new EchoWebSocketHandler(echoService());
	}

	@Bean
	public WebSocketHandler snakeWebSocketHandler() {
		return new PerConnectionWebSocketHandler(SnakeWebSocketHandler.class);
	}

	@Bean
	public DefaultEchoService echoService() {
		return new DefaultEchoService("Did you say \"%s\"?");
	}

}
