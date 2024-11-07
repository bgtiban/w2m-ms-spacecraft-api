package es.w2m.infrastructure;

import es.w2m.domain.ISpaceshipRepositoryPort;
import es.w2m.domain.model.PageableDomainModel;
import es.w2m.domain.model.SpaceshipDomainModel;
import es.w2m.infrastructure.jpa.ISpaceShipPageableMapperInfra;
import es.w2m.infrastructure.jpa.ISpaceshipRepository;
import es.w2m.infrastructure.jpa.SpaceshipEntity;
import es.w2m.infrastructure.rabbitmq.RabbitMqConfiguration;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@AllArgsConstructor
@NoArgsConstructor
public class SpaceshipRepositoryAdapter implements ISpaceshipRepositoryPort {

    @Autowired
    private ISpaceshipRepository repository;

    @Autowired
    private ISpaceShipPageableMapperInfra mapper;

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Override
    public PageableDomainModel searchSpaceshipsWithPartialName(String name, Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        return mapper.toPageableDomain(repository.findByNameContainingIgnoreCase(name, pageable));
    }

    @Override
    public PageableDomainModel searchSpaceships(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        return mapper.toPageableDomain(repository.findAll(pageable));
    }

    @Override
    public SpaceshipDomainModel searchSpaceshipById(Long id) {
        return mapper.toDomain(repository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("No existe nave con id: " + id)));
    }

    @Override
    public SpaceshipDomainModel createSpaceship(SpaceshipDomainModel newSpaceship) {
        SpaceshipEntity spaceship = mapper.toEntity(newSpaceship);
        rabbitTemplate.convertAndSend(RabbitMqConfiguration.QUEUE_SPACESHIP_CREATED, spaceship);
        return mapper.toDomain(repository.save(spaceship));
    }

    @Override
    public SpaceshipDomainModel updateSpaceship(SpaceshipDomainModel spaceship) {
        return mapper.toDomain(repository.save(mapper.toEntity(spaceship)));
    }

    @Override
    public void deleteSpaceshipById(Long spaceshipId) {
        repository.deleteById(spaceshipId);
    }
}
