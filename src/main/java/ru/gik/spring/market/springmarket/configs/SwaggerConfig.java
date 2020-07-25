package ru.gik.spring.market.springmarket.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@Configuration
@EnableSwagger2
public class SwaggerConfig {
  //  http://localhost:8182/market/swagger-ui.html - аддрес для доступа к свагеру
    //http://localhost:8182/market/v2/api-docs - без ui
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("ru.gik.spring.market.springmarket.controllers"))
                .paths(PathSelectors.regex("/api.*"))
               /* .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())*/
                .build();
    }
}

