package org.open.lang.ms.note.ws.interceptor;

import org.open.lang.ms.note.ws.consts.WsConsts;
import org.soul.base.lang.collections.CollectionTool;
import org.soul.ms.user.common.vo.login.UserInfoModel;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Deprecated
public class MyWebSocketHandler implements WebSocketHandler {

    private ConcurrentHashMap<String, List<WebSocketSession>> userMap = new ConcurrentHashMap<>();


    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        UserInfoModel userInfoModel = (UserInfoModel) session.getAttributes().get(WsConsts.WS_ATTR_USER_INFO);
        List<WebSocketSession> webSocketSessions = userMap.get(userInfoModel.getUsername());
        if (CollectionTool.isEmpty(webSocketSessions)){
            webSocketSessions = new LinkedList<>();
        }
        webSocketSessions.add(session);
        userMap.put(userInfoModel.getUsername(),webSocketSessions);
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {

    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {

    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {

    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }
}
