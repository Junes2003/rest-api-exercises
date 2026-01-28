package org.example01restapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "org.example01restapi.exercise3")public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
