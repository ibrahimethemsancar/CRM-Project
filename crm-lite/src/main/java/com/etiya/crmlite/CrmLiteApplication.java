package com.etiya.crmlite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class CrmLiteApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrmLiteApplication.class, args);
    }



}
