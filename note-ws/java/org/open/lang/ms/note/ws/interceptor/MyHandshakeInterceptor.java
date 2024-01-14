package org.open.lang.ms.note.ws.interceptor;

import lombok.Setter;
import org.soul.base.lang.string.StringTool;
import org.soul.base.log.Log;
import org.soul.base.log.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.session.Session;
import org.springframework.session.SessionRepository;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import java.util.Map;

@Setter
public class MyHandshakeInterceptor implements HandshakeInterceptor {

    private static final String SPRING_SESSION_ID_ATTR_NAME = "SPRING.SESSION.ID";
    Log log = LogFactory.getLog(MyHandshakeInterceptor.class);

    @Autowired
    private SessionRepository<Session> sessionRepository;

    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {
        if (request instanceof ServletServerHttpRequest) {
            String sessionId = (String) attributes.get(SPRING_SESSION_ID_ATTR_NAME);
            if (StringTool.isEmpty(sessionId)) {
                return false;
            }
            Session session = this.sessionRepository.findById(sessionId);
            if (session != null) {
                SecurityContext context = session.getAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY);
                //Authentication authentication = context.getAuthentication();
                SecurityContextHolder.setContext(context);
                return true;
            }
        }
        return false;
    }


    @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Exception exception) {

    }
}
