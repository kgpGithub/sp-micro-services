package org.ssl.examples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CuctomerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CuctomerApplication.class, args);
	}

}
