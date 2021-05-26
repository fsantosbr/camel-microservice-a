package com.fsantos.camelmicroservicea.routes.a;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

@Component
public class GetCurrentTimeBean {

    public String getCurrentTime(){
        return "Time right now is " + LocalDateTime.now();
    }
    
}
