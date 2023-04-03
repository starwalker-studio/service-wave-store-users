package com.wavestore.service.users;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan({ "com.wavestore.service.users.commons.models.entity" })
@SpringBootApplication(scanBasePackages = { 
		"com.wavestore.service.users.service",
		"com.wavestore.service.users.dao",
		"com.wavestore.service.users.controllers",
		"com.wavestore.service.users.config"})
public class ServiceWaveStoreUsersApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceWaveStoreUsersApplication.class, args);
	}

}
