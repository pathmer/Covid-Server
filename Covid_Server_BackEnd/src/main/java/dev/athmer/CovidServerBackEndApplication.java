package dev.athmer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication // allows auto configuration
@ComponentScan("dev.athmer") // alerts spring to look for components / stereotypes
@EnableJpaRepositories("dev.athmer.repositories") // tells spring where our repos are
@EntityScan("dev.athmer.models") // tells spring where our entities are
public class CovidServerBackEndApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(CovidServerBackEndApplication.class, args);
	}

}
