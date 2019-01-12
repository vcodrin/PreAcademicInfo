package com.example.preAcademicInfo.utils;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:validation.properties")
public class EnvUtil {

    private final Environment env;

    @Autowired
    public EnvUtil(Environment env) {
        this.env = env;
    }

    public Environment getEnv() {
        return env;
    }
}
