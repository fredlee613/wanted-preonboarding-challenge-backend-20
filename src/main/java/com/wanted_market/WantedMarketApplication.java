package com.wanted_market;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class WantedMarketApplication {

	public static void main(String[] args) {
		SpringApplication.run(WantedMarketApplication.class, args);
	}

}
