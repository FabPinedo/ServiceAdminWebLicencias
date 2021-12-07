package com.aquarius.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class BackendAdminLicenciasApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendAdminLicenciasApplication.class, args);
	}
	
	
}
