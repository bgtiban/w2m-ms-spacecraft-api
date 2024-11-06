package es.w2m.domain;

public interface ISpaceshipRepositoryPort {
    PageableDomain searchSpaceships(String name, Integer page, Integer size);
}
