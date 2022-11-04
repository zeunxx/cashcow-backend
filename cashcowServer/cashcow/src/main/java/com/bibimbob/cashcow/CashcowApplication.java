package com.bibimbob.cashcow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CashcowApplication {

	public static void main(String[] args) {
		SpringApplication.run(CashcowApplication.class, args);
	}

}
