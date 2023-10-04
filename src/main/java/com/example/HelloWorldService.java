package com.example;


import io.micronaut.context.annotation.Primary;
import jakarta.inject.Singleton;

 //This annotation is coming from jakarta dependency singleton means that
 // only one instance of class will exist in this micronaut application
 @Primary
 @Singleton
public class HelloWorldService implements MyService {

    @Override
     public String helloFromService(){
         return "Hello From Service";
     }
}
