package com.deutsche.bank.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import java.util.Locale;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;

/**
 * Web configuration.
 *
 * @author Yuniel Acosta
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

  /**
   * Locale resolver. This is used to set the default locale.
   *
   * @return LocaleResolver
   */
  @Bean
  public LocaleResolver localeResolver() {
    return new FixedLocaleResolver(Locale.US);
  }

  @Bean
  public OpenAPI customOpenAPI() {
    return new OpenAPI()
        .info(new Info()
            .title("Deutsche Bank Demo")
            .version("0.1")
            .description("Sample app Spring Boot 3 with Swagger")
            .termsOfService("http://swagger.io/terms/")
            .license(new License().name("Apache 2.0").url("http://springdoc.org")));

  }

}
