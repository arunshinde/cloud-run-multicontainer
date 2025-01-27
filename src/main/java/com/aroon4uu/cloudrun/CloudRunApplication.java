package com.aroon4uu.cloudrun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class CloudRunApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudRunApplication.class, args);
    }

}

@RestController
class HelloController {
	@GetMapping("/")
	public String hello() {
		return "Hello from Cloud Run!";
	}

}