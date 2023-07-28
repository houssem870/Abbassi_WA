/**
 * The {@code SwaggerConfig} class is a Spring configuration class that sets up Swagger for API documentation.
 *
 * <p>Swagger is a tool that allows automatic generation of interactive API documentation, which is especially useful
 * for RESTful APIs. This class configures Swagger to scan and document the API endpoints defined in the controllers
 * package (com.group.Abbassi_WA.controllers).</p>
 *
 * <p>By enabling Swagger with {@code @EnableSwagger2}, the API documentation will be available at the endpoint
 * '/swagger-ui.html' when the application is running. It provides a user-friendly interface for exploring and testing
 * the available endpoints.</p>
 *
 * <p>To use Swagger, make sure you have added the necessary dependencies for Swagger and Swagger UI in your project.
 * For example, in a Maven-based project, you can include the following dependencies in your pom.xml:</p>
 * <pre>{@code
 * <dependency>
 *     <groupId>io.springfox</groupId>
 *     <artifactId>springfox-swagger2</artifactId>
 *     <version>${springfox.version}</version>
 * </dependency>
 *
 * <dependency>
 *     <groupId>io.springfox</groupId>
 *     <artifactId>springfox-swagger-ui</artifactId>
 *     <version>${springfox.version}</version>
 * </dependency>
 * }</pre>
 *
 * <p>After configuring Swagger, you can access the API documentation by navigating to '/swagger-ui.html' in your
 * web browser once the application is running.</p>
 *
 * @see <a href="https://swagger.io/">Swagger Documentation</a>
 * @see <a href="https://github.com/springfox/springfox">Springfox GitHub Repository</a>
 * @see com.java.Abbassi_WA.controllers (Controllers package containing API endpoints)
 * @see springfox.documentation.spring.web.plugins.Docket
 * @see springfox.documentation.swagger2.annotations.EnableSwagger2
 * @see org.springframework.context.annotation.Configuration
 * @since 1.0
 */

package com.group.Abbassi_WA.configuration;

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

    /**
     * Configures Swagger for API documentation.
     *
     * @return A Docket instance representing the configured Swagger API documentation.
     */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.group.Abbassi_WA.configuration"))
                .paths(PathSelectors.any())
                .build();
    }
}
