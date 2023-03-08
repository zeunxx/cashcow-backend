package com.bibimbob.cashcow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableFeignClients
@EnableJpaAuditing
public class CashcowApplication {

	public static void main(String[] args) {
		SpringApplication.run(CashcowApplication.class, args);
	}

}
