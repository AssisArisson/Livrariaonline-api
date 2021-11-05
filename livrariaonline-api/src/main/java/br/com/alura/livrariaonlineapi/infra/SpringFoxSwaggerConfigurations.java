package br.com.alura.livrariaonlineapi.infra;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.RequestParameterBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Arrays;
import java.util.Collections;

@Configuration
public class SpringFoxSwaggerConfigurations {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                . globalRequestParameters(Arrays.asList(
                        new RequestParameterBuilder()
                                .name("Authorization")
                                .description("Bearer Token")
                                .required(false)
                                .in("header")
                                .build()
                ))
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "API Livraria Online",
                "API Destinada para fornecer serviços para Livrarias",
                "0.0.1",
                "Termos de serviço",
                new Contact("Arisson Assis", "www.example.com", "arisson@gmail.com"),
                "License of API", "API license URL", Collections.emptyList());

    }
}