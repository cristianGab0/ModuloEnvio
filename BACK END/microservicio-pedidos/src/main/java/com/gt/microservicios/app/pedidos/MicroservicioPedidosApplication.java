package com.gt.microservicios.app.pedidos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MicroservicioPedidosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicioPedidosApplication.class, args);
	}

}
