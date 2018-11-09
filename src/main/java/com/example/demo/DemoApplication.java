package com.example.demo;

import com.example.demo.controller.RandomNumberController;
import com.example.demo.service.RandomService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);

        RandomService service = new RandomService();
        RandomNumberController ctrl = new RandomNumberController(service);

    }
}
