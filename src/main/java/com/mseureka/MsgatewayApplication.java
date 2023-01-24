package com.mseureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class MsgatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsgatewayApplication.class, args);
	}
	
	@Bean
	 RouteLocator routes(RouteLocatorBuilder builder) {
		return builder.routes()
					.route(r -> r.path("put here the service path").uri("lb://put here the name of the service"))
					//.route(r -> r.path("/v1/units-of-measurement/**").uri("lb://msunitofmeasurement"))
				.build();
	}

}
