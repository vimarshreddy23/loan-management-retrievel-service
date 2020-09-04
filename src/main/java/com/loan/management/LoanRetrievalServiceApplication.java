package com.loan.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class LoanRetrievalServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoanRetrievalServiceApplication.class, args);
	}

}
