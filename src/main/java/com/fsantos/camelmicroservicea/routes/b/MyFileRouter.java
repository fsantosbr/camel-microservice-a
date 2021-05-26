package com.fsantos.camelmicroservicea.routes.b;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;


@Component
public class MyFileRouter extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("file:files/input")
        .log("${body}")
        .to("file:files/output");

        // no need to create the folders. In Eclipse, they will appear here. In Vscode, we can find them in the local repository
        // .log("${body}") vai exibir no console o conteúdo do arquivo.
    }
    
}
