package es.w2m.domain;

import es.w2m.domain.model.PageableDomainModel;
import es.w2m.domain.model.SpaceshipDomainModel;

public interface ISpaceshipService {

    PageableDomainModel searchSpaceships(String name, Integer page, Integer size);

    SpaceshipDomainModel searchSpaceshipById(Long id);

    SpaceshipDomainModel createSpaceship(SpaceshipDomainModel newSpaceshipName);

    SpaceshipDomainModel updateSpaceship(SpaceshipDomainModel spaceshipDomainExpected);

    void deleteSpaceshipById(Long spaceshipId);
}
