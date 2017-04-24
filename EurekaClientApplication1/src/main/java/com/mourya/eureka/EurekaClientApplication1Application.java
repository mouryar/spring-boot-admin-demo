package com.mourya.eureka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.cloud.client.discovery.DiscoveryClient;



@SpringBootApplication
@EnableEurekaClient
@RestController
public class EurekaClientApplication1Application {

	@Autowired
	private DiscoveryClient discoverClient;
	
	public static void main(String[] args) {
		SpringApplication.run(EurekaClientApplication1Application.class, args);
	}
	
	@RequestMapping("/greeting")
    public String greeting() {
		
		System.out.println(discoverClient.getInstances("spring-cloud-eureka-client").get(0).getHost());
		System.out.println(discoverClient.getInstances("spring-cloud-eureka-client").get(0).getUri());
        return "Hello from EurekaClient-1!";
    }
}
