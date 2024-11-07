package es.w2m.domain;

public interface ISpaceshipRepositoryPort {
    PageableDomain searchSpaceships(String name, Integer page, Integer size);

    SpaceshipDomain searchSpaceshipById(Long id);

    SpaceshipDomain createSpaceship(SpaceshipDomain newSpaceship);

    SpaceshipDomain updateSpaceship(SpaceshipDomain spaceship);

    void deleteSpaceshipById(Long spaceshipId);
}
