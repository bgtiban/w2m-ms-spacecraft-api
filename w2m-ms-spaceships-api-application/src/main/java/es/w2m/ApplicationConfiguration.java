package es.w2m;

import es.w2m.domain.ISpaceshipRepositoryPort;
import es.w2m.domain.ISpaceshipService;
import es.w2m.domain.SpaceshipServiceImpl;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

  @Bean
  public OpenAPI getOpenAPI() {
    return new OpenAPI().addServersItem(new Server().url("/").description("Application Server URL"));
  }  

  @Bean
  public ISpaceshipService getSpaceshipService(ISpaceshipRepositoryPort repo) {
    return new SpaceshipServiceImpl(repo);
  }
}

