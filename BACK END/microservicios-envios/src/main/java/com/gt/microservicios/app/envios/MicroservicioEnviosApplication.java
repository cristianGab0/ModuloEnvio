package com.gt.microservicios.app.envios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@EnableEurekaClient
@SpringBootApplication
public class MicroservicioEnviosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicioEnviosApplication.class, args);
	}

}
