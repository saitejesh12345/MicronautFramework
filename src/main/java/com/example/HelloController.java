package com.example;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;
import jakarta.inject.Inject;
import lombok.extern.java.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//	The class is defined as a controller with the @Controller annotation mapped to the path /hello.
@Controller("/hello")
public class HelloController {

    //to debug the code
private static  final Logger log = LoggerFactory.getLogger(HelloController.class);


    //Constructor based DI
    private final MyService service;
    public HelloController(MyService service) {
        this.service = service;
    }

    //Field based DI
//    @Inject
//    private HelloWorldService service;

        @Get
        @Produces(MediaType.TEXT_PLAIN)
        //	By default, a Micronaut response uses application/json as Content-Type.
            //	We are returning a String, not a JSON object, so we set it to text/plain.
       public String index() {
            log.debug("Called the hello world API");
           return service.helloFromService();
        }
}
