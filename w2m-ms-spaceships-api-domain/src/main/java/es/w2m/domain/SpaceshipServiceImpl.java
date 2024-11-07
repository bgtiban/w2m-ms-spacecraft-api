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

    @Override
    public SpaceshipDomain searchSpaceshipById(Long id) {
        return spaceshipRepository.searchSpaceshipById(id);
    }

    @Override
    public SpaceshipDomain createSpaceship(SpaceshipDomain newSpaceship) {
        return spaceshipRepository.createSpaceship(newSpaceship);
    }

    @Override
    public SpaceshipDomain updateSpaceship(SpaceshipDomain spaceshipDomainExpected) {
        return spaceshipRepository.updateSpaceship(spaceshipDomainExpected);
    }

    @Override
    public void deleteSpaceshipById(Long spaceshipId) {
        spaceshipRepository.deleteSpaceshipById(spaceshipId);
    }
}
