package com.gcu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"com.gcu"})
@SpringBootApplication
public class Activity43Application {

	public static void main(String[] args) {
		SpringApplication.run(Activity43Application.class, args);
	}
}
