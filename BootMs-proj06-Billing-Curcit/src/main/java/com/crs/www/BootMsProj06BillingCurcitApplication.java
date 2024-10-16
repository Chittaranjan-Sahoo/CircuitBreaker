package com.crs.www;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BootMsProj06BillingCurcitApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootMsProj06BillingCurcitApplication.class, args);
	}

}
