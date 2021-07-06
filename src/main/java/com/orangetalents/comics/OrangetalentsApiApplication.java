package com.orangetalents.comics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class OrangetalentsApiApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(OrangetalentsApiApplication.class, args);		
	}
}
