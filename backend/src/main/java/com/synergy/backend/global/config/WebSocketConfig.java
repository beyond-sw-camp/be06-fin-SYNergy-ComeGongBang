package com.synergy.backend.global.config;

import com.synergy.backend.global.Handler.QueueWebSocketHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
    private final QueueWebSocketHandler queueWebSocketHandler;

    public WebSocketConfig(QueueWebSocketHandler queueWebSocketHandler) {
        this.queueWebSocketHandler = queueWebSocketHandler;
    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(queueWebSocketHandler, "/ws/queue").setAllowedOrigins("*");

    }
}
