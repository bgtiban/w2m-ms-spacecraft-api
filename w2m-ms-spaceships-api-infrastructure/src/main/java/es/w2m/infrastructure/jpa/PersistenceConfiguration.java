package es.w2m.infrastructure.jpa;

import es.w2m.domain.ISpaceshipRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersistenceConfiguration {

    @Bean
    ISpaceshipRepositoryPort getSpaceshipRepositoryAdapter(ISpaceshipRepository repo, ISpaceShipPageableMapperInfra mapper) {
        return new SpaceshipRepositoryAdapterJPA(repo, mapper);
    }
}
