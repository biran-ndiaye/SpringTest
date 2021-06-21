package com.example.demosringappweb.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
@ConfigurationProperties(prefix = "com.exemple.demospringappweb")
public class Customproperties {
    private String apiUrl ;
}
