package es.w2m.infrastructure.rabbitmq;

import es.w2m.domain.ISpaceshipRepositoryPort;
import es.w2m.infrastructure.SpaceshipRepositoryAdapter;
import es.w2m.infrastructure.jpa.ISpaceShipPageableMapperInfra;
import es.w2m.infrastructure.jpa.ISpaceshipRepository;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfiguration {

    public static final String QUEUE_SPACESHIP_CREATED = "queue.spaceship.created";

    @Bean
    public Queue queue() {
        return new Queue(QUEUE_SPACESHIP_CREATED, true);
    }

    @Bean
    public Jackson2JsonMessageConverter producerJackson2MessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
