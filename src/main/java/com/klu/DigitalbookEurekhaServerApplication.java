package com.klu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@EnableEurekaServer
@SpringBootApplication
public class DigitalbookEurekhaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DigitalbookEurekhaServerApplication.class, args);
	}

}
