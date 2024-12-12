package com.luisguilherme.parts_catalog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@OpenAPIDefinition
@Configuration
public class OpenAPIConfig {

	@OpenAPIDefinition
	@Configuration
	public class OpenApiConfig {

        @Bean
        OpenAPI partsCatalogAPI() {
			return new OpenAPI()
					.info(new Info()
					.title("Parts Catalog")
					.description("Catálogo Online de Peças Automotivas.")
					.version("v0.0.1")
					.license(new License()
					.name("Apache 2.0")
					.url("https://github.com/luisguilheerme/parts-catalog")));
		}
	}

}