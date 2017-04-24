package com.mourya.eureka;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@EnableEurekaClient
@RestController
public class EurekaClientApplication {

	@Autowired
	private DiscoveryClient discoverClient;
	
	public static void main(String[] args) {
		SpringApplication.run(EurekaClientApplication.class, args);
	}
	
	@RequestMapping("/greeting")
    public String greeting() {
		
		System.out.println(discoverClient.getInstances("spring-cloud-eureka-client1").get(0).getHost());
		System.out.println(discoverClient.getInstances("spring-cloud-eureka-client1").get(0).getUri());
        return "Hello from EurekaClient!";
    }
}
