package com.example;

import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;


@MicronautTest
public class HelloWorldControllerTest {

    //To able to fetch data from a rest APi end point,we need a Http Client.
    //We need to add inject annotation and Add Client annotation,we dont have specific path
    //so we just use slash. Micronaut will create all code by using Annotation Processing
    //to inject  the Http Client properly.
    @Inject
    @Client("/")
    HttpClient client;


    //Default HttpClient ProvidedBy Micronaut is reactive and non-blocking which is general
    //verygood and i recommend to use that functionality.It is also called BlockingFashion

    @Test
    void helloWorldEndpointRespondsWithProperContent(){
        var response = client.toBlocking().retrieve("/hello");
        assertEquals("Hello From Service",response);

    }
    @Test
    void helloWorldEndpointRespondsWithProperStatusCodeAndContent() {
//to reserve the Http response code we need to change the client to bocking,Retrive
        //to Client to blocking exchange
        //This exchange function will return the Http responseObject not only body
        var response = client.toBlocking().exchange("/hello", String.class);
        assertEquals(HttpStatus.OK, response.getStatus());
        assertEquals("Hello From Service", response.getBody().get());

    }
}
