package com.demoproject.springbootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class SpringbootdemoApplication {
	private final Environment env;
	public SpringbootdemoApplication(Environment env) {
        this.env = env;
    }
	public static void main(String[] args) {
		SpringApplication.run(SpringbootdemoApplication.class, args);
	}

}
