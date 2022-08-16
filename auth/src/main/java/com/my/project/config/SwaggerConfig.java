package com.my.project.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

/**
 * Swagger Config
 *
 * @author
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
            .apiInfo(apiInfo())
            .select()
            //Only the classes annotated with apioperation can generate interface documents
            .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
            //Only the classes under the package can generate interface documents.
            .apis(RequestHandlerSelectors.basePackage("com.my.project.config.controller"))
            .paths(PathSelectors.any())
            .build()
            .directModelSubstitute(java.util.Date.class, String.class)
            .securitySchemes(security());

    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title("My Project")
            .description("Certification module development document")
            .termsOfServiceUrl("https://www.bmw.com.cn/")
            .version("1.1.0")
            .build();
    }

    private List<ApiKey> security() {
        return newArrayList(
            new ApiKey("token", "token", "header")
        );
    }

}
