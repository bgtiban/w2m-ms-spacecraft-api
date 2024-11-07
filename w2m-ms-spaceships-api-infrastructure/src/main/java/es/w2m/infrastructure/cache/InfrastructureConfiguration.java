package es.w2m.infrastructure.cache;

import es.w2m.domain.ISpaceshipRepositoryPort;
import es.w2m.infrastructure.jpa.ISpaceShipPageableMapperInfra;
import es.w2m.infrastructure.jpa.ISpaceshipRepository;
import es.w2m.infrastructure.jpa.SpaceshipRepositoryAdapterJPA;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class InfrastructureConfiguration {

    @Bean
    ISpaceshipRepositoryPort getSpaceshipRepositoryAdapter(ISpaceshipRepository repo, ISpaceShipPageableMapperInfra mapper) {
        return new SpaceshipRepositoryAdapterJPA(repo, mapper);
    }
}
