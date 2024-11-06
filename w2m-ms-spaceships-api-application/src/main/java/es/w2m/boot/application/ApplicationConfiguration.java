package es.w2m.boot.application;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

  @Bean
  public OpenAPI openAPI() {
    return new OpenAPI().addServersItem(new Server().url("/").description("Application Server URL"));
  }  
  
}

