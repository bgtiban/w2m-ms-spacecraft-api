package es.w2m.infrastructure.jpa;

import es.w2m.domain.ISpaceshipRepositoryPort;
import es.w2m.infrastructure.SpaceshipRepositoryAdapter;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JpaConfiguration {
    @Bean
    ISpaceshipRepositoryPort getSpaceshipRepositoryAdapter(ISpaceshipRepository repo, ISpaceShipPageableMapperInfra mapper,
                                                           RabbitTemplate rabbitTemplate) {
        return new SpaceshipRepositoryAdapter(repo, mapper, rabbitTemplate);
    }
}
