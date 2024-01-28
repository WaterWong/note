package org.open.lang.ms.note.api.starter;


import org.soul.ability.security.spring.core.authc.jwt.DefaultJwtTokenGenerator;
import org.soul.ability.security.spring.core.authc.jwt.JwtTokenGenerator;
import org.soul.base.log.Log;
import org.soul.base.log.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.jwt.JwtEncoder;

import javax.annotation.PostConstruct;


@Configuration
@ComponentScan(basePackages = "org.open.lang.ms.note.api")
public class NoteConfiguration {
    private Log log = LogFactory.getLog(NoteConfiguration.class);

    @PostConstruct
    public void init() {
        log.info("NoteViewConfiguration：加载完成。");
    }

    @Autowired
    JwtEncoder jwtEncoder;

    @Bean
    public JwtTokenGenerator jwtTokenGenerator(){
        DefaultJwtTokenGenerator jwtTokenGenerator = new DefaultJwtTokenGenerator();
        jwtTokenGenerator.setJwtEncoder(jwtEncoder);
        return jwtTokenGenerator;
    }
}
