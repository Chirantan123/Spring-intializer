package com.example.Spring.Session1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SpringSession1Application {
	public static void main(String[] args) {
		System.out.println("Hello World");
		SpringApplication.run(SpringSession1Application.class, args);
	}

}
