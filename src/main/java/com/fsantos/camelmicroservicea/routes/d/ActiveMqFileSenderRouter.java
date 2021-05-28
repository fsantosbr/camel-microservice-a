package com.fsantos.camelmicroservicea.routes.d;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ActiveMqFileSenderRouter extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("file:files/input-queue-folder")
        .log("${body}")
        .to("activemq:activemq-files-queue");


        // from("file:files/input-queue-folder") = the endpoint "file" and the folder name that will be created automatically
        // .log("${body}") vai exibir no console o conteúdo do arquivo.
        // .to("activemq:activemq-files-queue"); = activemq is the endpoint that is used with an import in the pom.
        // .to("activemq:activemq-files-queue"); = activemq-files-queue is the name of a queue that will be created automatically in the activemq 
        
    }
    
}
