package com.l3a.coinRanking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CoinRankingApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoinRankingApplication.class, args);
	}

}
