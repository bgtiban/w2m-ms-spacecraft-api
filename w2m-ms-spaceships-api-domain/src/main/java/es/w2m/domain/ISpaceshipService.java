package es.w2m.domain;

public interface ISpaceshipService {

    PageableDomain searchSpaceships(String name, Integer page, Integer size);
}
