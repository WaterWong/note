package org.open.lang.ms.note.ws.mvc;

import lombok.Setter;
import org.soul.base.log.Log;
import org.soul.base.log.LogFactory;
import org.soul.base.web.WebResult;
import org.soul.ms.user.common.vo.login.UserInfoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@ControllerAdvice
@Setter
public class MyMessageInterceptor implements ResponseBodyAdvice<Object> {

    private Log LOG = LogFactory.getLog(MyMessageInterceptor.class);

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Override
    public boolean supports(MethodParameter handlerMethod, Class<? extends HttpMessageConverter<?>> converterType) {
        //warning: 引入以下pom,会导致
        // - soul-ability-web-springmvc handlerMethod获取不到原始controller里的方法
        SendTo sendTo = handlerMethod.getMethodAnnotation(SendTo.class);
        SendToUser sendToUser = handlerMethod.getMethodAnnotation(SendToUser.class);
        return sendTo != null || sendToUser != null;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter handlerMethod, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        SendTo sendTo = handlerMethod.getMethodAnnotation(SendTo.class);
        SendToUser sendToUser = handlerMethod.getMethodAnnotation(SendToUser.class);
        Object item = body;
        if (body instanceof WebResult<?> w) {
            item = w.getData();
        }
        if (sendTo != null) {
            messagingTemplate.convertAndSend(sendTo.value()[0], item);
        } if (sendToUser != null){
            SecurityContext context = SecurityContextHolder.getContext();
            if (context.getAuthentication() != null) {
                if (context.getAuthentication().getPrincipal() instanceof UserInfoModel user ){
                    messagingTemplate.convertAndSendToUser(user.getUsername(), sendToUser.value()[0], item);
                }
            }
        }
        return body;
    }
}
