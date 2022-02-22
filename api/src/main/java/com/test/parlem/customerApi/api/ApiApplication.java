package com.test.parlem.customerApi.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication(scanBasePackages = {"com.test.parlem.customerApi.persistence","com.test.parlem.customerApi.domain", "com.test.parlem.customerApi.api"})
@EnableJpaRepositories("com.test.parlem.customerApi.persistence")
@EntityScan("com.test.parlem.customerApi.persistence")
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}
}
