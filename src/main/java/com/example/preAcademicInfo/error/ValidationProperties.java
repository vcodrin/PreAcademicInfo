package com.example.preAcademicInfo.error;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:validation.properties")
public class ValidationProperties {

    public ValidationProperties(){
        super();
    }
}
