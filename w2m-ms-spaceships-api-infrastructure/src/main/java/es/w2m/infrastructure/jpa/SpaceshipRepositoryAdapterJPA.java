package es.w2m.infrastructure.jpa;

import es.w2m.domain.ISpaceshipRepositoryPort;
import es.w2m.domain.PageableDomain;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@AllArgsConstructor
@NoArgsConstructor
public class SpaceshipRepositoryAdapterJPA implements ISpaceshipRepositoryPort {

    @Autowired
    private ISpaceshipRepository repository;

    @Autowired
    private ISpaceShipPageableMapperInfra mapper;

    @Override
    public PageableDomain searchSpaceships(String name, Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        return mapper.toPageableDomain(repository.findByNameContainingIgnoreCase(name, pageable));
    }
}
