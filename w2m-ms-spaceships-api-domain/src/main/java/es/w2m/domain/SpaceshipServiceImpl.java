package es.w2m.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@AllArgsConstructor
@NoArgsConstructor
public class SpaceshipServiceImpl implements ISpaceshipService {

    @Autowired
    private ISpaceshipRepositoryPort spaceshipRepository;

    @Override
    public PageableDomain searchSpaceships(String name, Integer page, Integer size) {
        return spaceshipRepository.searchSpaceships(name, page, size);
    }
}
