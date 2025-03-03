package com.portfolio.review.infrastructure.in.rest.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("Review API")
                .version("1.0")
                .description("API para gestionar reviews")
                .contact(new Contact()
                    .name("Tu Nombre")
                    .email("tuemail@ejemplo.com")
                    .url("https://tu-sitio.com")
                )
            )
            .servers(List.of(
                new Server().url("http://localhost:8080").description("Servidor Local")
            ));
    }
}
