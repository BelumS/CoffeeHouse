package com.quadcore.chat.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 * The file that configures the WebSocket using Java Annotations
 * <p>
 * @author Quadcore
 * @version 1.0
 * @see AbstractWebSocketMessageBrokerConfigurer
 *
 */
@Configuration
@EnableWebSocketMessageBroker
@ComponentScan(basePackages = "com.quadcore.chat.controller")
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {
	
	//Configures where the communication enters and leaves
	@Override
	public void configureMessageBroker(MessageBrokerRegistry config)
	{
		config.enableSimpleBroker("/topic");
		config.setApplicationDestinationPrefixes("/app");
	}

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) 
	{
		registry.addEndpoint("/chat").withSockJS();
	}

}
