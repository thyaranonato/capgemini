package com.aulas.mvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MsLocaisApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsLocaisApplication.class, args);
	}

}
