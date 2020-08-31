package com.fisglobal.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.fisglobal.api.proxy")
@EnableDiscoveryClient
public class LibraryApiServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryApiServiceApplication.class, args);
	}

}
