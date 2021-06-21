package com.example.demosringappweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoSringAppWebApplication implements CommandLineRunner {
    @Autowired
    private com.example.demosringappweb.configuration.Customproperties customProperties;
    public static void main(String[] args) {
        SpringApplication.run(DemoSringAppWebApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println( customProperties.getApiUrl());
    }
}
