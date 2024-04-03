package com.rfp11.mybookrecipe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication(scanBasePackages = { "com.rfp11.mybookrecipe", "lib.i18n" })
@EnableJpaAuditing
public class MybookrecipeApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybookrecipeApplication.class, args);
	}

}
