package com.sirius.closeup.normalization;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableJpaAuditing
@EnableScheduling
@EnableSwagger2
public class NormalizationApplication {

	public static void main(String[] args) {
		SpringApplication.run(NormalizationApplication.class, args);
	}

}
