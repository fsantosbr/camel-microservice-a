package com.fsantos.camelmicroservicea.routes.a;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
//@Component
public class MyFirstTimeRouter extends RouteBuilder{

    @Autowired
    GetCurrentTimeBean getCurrentTimeBean;

    @Autowired
    SimpleLoggingProcessingComponent loggingComponent;

    @Override
    public void configure() throws Exception {
        
        from("timer:first-timer") //null
        .log("${body}") //null
        .transform().constant("My Constant message")
        .log("${body}") //My Constant message
        
        //.transform().constant("Time right now is " + LocalDateTime.now())
        //.bean("getCurrentTimeBean")
        //.bean(getCurrentTimeBean, getCurrentTime)
        .bean(getCurrentTimeBean)
        .log("${body}") //Time right now is 2021-05-26T15:55:50.031389700
        .bean(loggingComponent)
        .log("${body}")

        .process(new SimpleLoggingProcessor())

        .to("log:first-timer"); //database

        // "'timer' and 'log' are both an endpoint (a queue)"
        // transform() = usamos para transformar a messagem no caminho
        // .bean("getCurrentTimeBean") = we're passing the name of a class, but with the first letter in lowercase
        // .bean(getCurrentTimeBean) = passamos uma injeção de dependencia. Se a classe tiver mais que um método, pode usar como segundo argumento.

        // we can do a transformation by using a bean or a transform
        // we can do a processing by using a bean or a process

    }    
}


