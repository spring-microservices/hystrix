package org.manu.springcloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@SpringBootApplication
public class HystrixApplication {

	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/startClient")
	public List startClient(){
		return this.restTemplate.getForObject("http://localhost:8888/service", List.class);
	}
	public static void main(String[] args) {
		SpringApplication.run(HystrixApplication.class, args);
	}
}
