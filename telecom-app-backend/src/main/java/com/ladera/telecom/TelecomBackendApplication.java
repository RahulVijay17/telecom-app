package com.ladera.telecom;

import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.JdbcClient;

import javax.sql.DataSource;

@SpringBootApplication
@EnableJpaAuditing
@OpenAPIDefinition(
		info = @Info(
				title = "Telecom  REST API Documentation",
				description = "Telecom REST API Documentation",
				version = "v1",
				contact = @Contact(
						name = "Rahul Vijay",
						email = "rahul@gmail.com",
						url = "https://www.telecom.com"
				),
				license = @License(
						name = "Ladera Technology",
						url = "https://www.laderatechnology.com"
				)
		),
		externalDocs = @ExternalDocumentation(
				description =  "Telecom REST API Documentation",
				url = "https://www.telecom.com/swagger-ui.html"
		)
)
public class TelecomBackendApplication {

	JdbcTemplate jdbcTemplate;


	public static void main(String[] args) {
		SpringApplication.run(TelecomBackendApplication.class, args);
	}
}
