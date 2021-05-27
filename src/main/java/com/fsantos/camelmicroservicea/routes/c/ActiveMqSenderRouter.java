package com.fsantos.camelmicroservicea.routes.c;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ActiveMqSenderRouter extends RouteBuilder {

    @Override
    public void configure() throws Exception {      
        //timer
        from("timer:active-mq-timer?period=10000")
        .transform().constant("My message for Active MQ")
        .log("${body}")
        .to("activemq:my-activemq-queue");

        // the endpoint 'activemq' won't work unless we import it in the pom.
        // 'my-activemq-queue' will be the name of the queue in the activemq
        // do not forget to put the url and port for the activemq inside of the application.properties

        //queue
        
    }
    
}
