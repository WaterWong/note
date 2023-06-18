package org.open.lang.ms.note.api;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.soul.context.context.EnableSoul;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.*;

@SpringBootApplication
@EnableWebMvc
@EnableSoul
@MapperScan( value = "org.open.lang.ms.note.api",annotationClass = Mapper.class)
public class NoteApiApplication {

    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        SpringApplication app = new SpringApplication(NoteApiApplication.class);
        ApplicationContext act = app.run(args);
        act.publishEvent(new ContextStartedEvent(act));
    }
}