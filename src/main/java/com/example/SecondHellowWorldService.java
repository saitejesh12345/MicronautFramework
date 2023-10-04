package com.example;

import io.micronaut.context.annotation.Primary;
import jakarta.inject.Singleton;



@Singleton
public class SecondHellowWorldService implements MyService{
    @Override
    public String helloFromService() {
        return "Hello from second Service";
    }
}
