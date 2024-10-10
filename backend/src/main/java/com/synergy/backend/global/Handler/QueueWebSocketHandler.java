package com.synergy.backend.global.Handler;

import com.synergy.backend.domain.queue.model.response.QueueStatus;
import com.synergy.backend.domain.queue.service.QueueRedisService;
import com.synergy.backend.global.common.BaseResponseStatus;
import com.synergy.backend.global.exception.BaseException;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.concurrent.ConcurrentHashMap;

@Component
@RequiredArgsConstructor
public class QueueWebSocketHandler extends TextWebSocketHandler {
    private final ConcurrentHashMap<String, WebSocketSession> sessions = new ConcurrentHashMap<>();
    private final QueueRedisService queueRedisService;
    private static final int MAX_TRAFFIC = 5;

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {

        // TODO 임시
        String queueId = "";
        Long userId = 1L;


        // 대기열 상태 확인
        QueueStatus status = queueRedisService.getMyPosition(queueId, userId);
        if (status == null || status.getPosition() == null) {
            session.close(CloseStatus.BAD_DATA.withReason("대기열 없음"));
            return;
        }

        // 대기열에 있어야만 웹소켓 세션을 저장
        sessions.put(session.getId(), session);
        session.sendMessage(new TextMessage(status.toString()));
    }

    // 대기열 상태 조회
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {

        System.out.println("대기열 상태 조회");

        String payload = message.getPayload();
        String[] parts = payload.split(",");
        String programId = String.valueOf(parts[0]);
        Long userId = Long.parseLong(parts[1]);
        QueueStatus status = queueRedisService.getMyPosition(programId, userId);
        int activeSessions = sessions.size();
        boolean canProceed = activeSessions < MAX_TRAFFIC;

        if (status == null) {
            System.out.println("status null?");
            throw new BaseException(BaseResponseStatus.NOT_FOUND_STATUS);
        }

        if (canProceed && status.getPosition() == 1) {
            System.out.println("대기열 상태 조회 나갈수있나?");

//            status.setEnableRequest(true);
//            redisPort.remove(programId, userId);
        }

        session.sendMessage(new TextMessage(status.toString()));
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        sessions.remove(session.getId());
    }
}
