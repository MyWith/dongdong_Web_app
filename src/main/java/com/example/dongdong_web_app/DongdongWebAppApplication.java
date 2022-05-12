package com.example.dongdong_web_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class DongdongWebAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(DongdongWebAppApplication.class, args);
    }

}
