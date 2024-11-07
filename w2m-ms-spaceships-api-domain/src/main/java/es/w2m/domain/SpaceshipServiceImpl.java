package es.w2m.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;

@AllArgsConstructor
@NoArgsConstructor
public class SpaceshipServiceImpl implements ISpaceshipService {

    @Autowired
    private ISpaceshipRepositoryPort spaceshipRepository;

    @Override
    @Cacheable(value = "searchSpaceships", key = "#name + '_' + #page + '_' + #size")
    public PageableDomain searchSpaceships(String name, Integer page, Integer size) {
        PageableDomain pageableDomain = null;
        if (name != null && !name.isBlank()) {
            pageableDomain = spaceshipRepository.searchSpaceshipsWithPartialName(name, page, size);
        } else {
            pageableDomain = spaceshipRepository.searchSpaceships(page, size);
        }
        return pageableDomain;
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
