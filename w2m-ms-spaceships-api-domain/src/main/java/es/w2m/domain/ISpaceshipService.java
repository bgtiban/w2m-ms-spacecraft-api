package es.w2m.domain;

public interface ISpaceshipService {

    PageableDomain searchSpaceships(String name, Integer page, Integer size);

    SpaceshipDomain searchSpaceshipById(Long id);

    SpaceshipDomain createSpaceship(SpaceshipDomain newSpaceshipName);

    SpaceshipDomain updateSpaceship(SpaceshipDomain spaceshipDomainExpected);

    void deleteSpaceshipById(Long spaceshipId);
}
