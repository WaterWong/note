package org.open.lang.ms.note.ws.interceptor;

import lombok.Getter;
import lombok.Setter;
import org.soul.ability.security.common.exception.JwtExpiredException;
import org.soul.ability.security.spring.core.consts.PassportCodeEnum;
import org.soul.ability.security.spring.core.exception.AccountTokenExpiredException;
import org.soul.ability.security.spring.core.exception.CustomAuthenticationException2;
import org.soul.ability.security.spring.core.exception.PassportException;
import org.soul.ability.security.spring.web.authentication.jwt.JwtAuthenticationToken;
import org.soul.base.log.Log;
import org.soul.base.log.LogFactory;
import org.soul.ms.user.common.vo.login.UserInfoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageType;
import org.springframework.messaging.support.ExecutorChannelInterceptor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtClaimNames;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtException;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.session.Session;
import org.springframework.session.SessionRepository;
import org.springframework.stereotype.Component;


/**
 * 本意: 获取HttpSession里的用户信息
 * 此类: 暂时没有意义
 */
@Setter
public class MyExecutorChannelInterceptor implements ExecutorChannelInterceptor {

    private static final String SPRING_SESSION_ID_ATTR_NAME = "SPRING.SESSION.ID";

    private Log log = LogFactory.getLog(MyExecutorChannelInterceptor.class);

    //@Autowired
    //private UserDetailsService userDetailsService;

    //@Autowired
    //private JwtDecoder jwtDecoder;

    @Autowired
    private SessionRepository<Session> sessionRepository;

    @Override
    public Message<?> beforeHandle(Message<?> message, MessageChannel channel, MessageHandler handler) {
        SimpMessageHeaderAccessor accessor = SimpMessageHeaderAccessor.wrap(message);
        if (accessor.getMessageType() == SimpMessageType.CONNECT) {
            String sessionId = (String) accessor.getSessionAttributes().get(SPRING_SESSION_ID_ATTR_NAME);
            if (sessionId != null) {
                Session session = this.sessionRepository.findById(sessionId);
                if (session != null) {
                    SecurityContext context = session.getAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY);
                    Authentication authentication = context.getAuthentication();
                    if (authentication.getPrincipal() instanceof UserInfoModel userInfoModel) {
                        accessor.setUser(() -> userInfoModel.getUsername());
                    }
                }
                return message;
            }
            // without session , not login
            return null;
        }
        return message;
    }

    //private Authentication getUser(String jwsToken) {
    //    String username = "";
    //    try {
    //        Jwt jwt = jwtDecoder.decode(jwsToken);
    //        username = jwt.getClaimAsString(JwtClaimNames.SUB);
    //    } catch (JwtExpiredException e) {
    //        throw new CustomAuthenticationException2("Jwt token expired!", new AccountTokenExpiredException(PassportCodeEnum.SC_JWT_TOKEN_EXPIRED));
    //    } catch (JwtException e) {
    //        throw new CustomAuthenticationException2("Jwt token invalid!", new PassportException(PassportCodeEnum.SC_JWT_TOKEN_IN_VALID));
    //    }
    //
    //    try {
    //        UserDetails user = getUserDetailsService().loadUserByUsername(username);
    //        return new JwtAuthenticationToken(user, user.getAuthorities());
    //    } catch (UsernameNotFoundException ex) {
    //        throw ex;
    //    }
    //}
}
