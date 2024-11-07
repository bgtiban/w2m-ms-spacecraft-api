package es.w2m.domain;

import es.w2m.domain.model.PageableDomainModel;
import es.w2m.domain.model.SpaceshipDomainModel;

public interface ISpaceshipRepositoryPort {
    PageableDomainModel searchSpaceshipsWithPartialName(String name, Integer page, Integer size);

    PageableDomainModel searchSpaceships(Integer page, Integer size);

    SpaceshipDomainModel searchSpaceshipById(Long id);

    SpaceshipDomainModel createSpaceship(SpaceshipDomainModel newSpaceship);

    SpaceshipDomainModel updateSpaceship(SpaceshipDomainModel spaceship);

    void deleteSpaceshipById(Long spaceshipId);

}
