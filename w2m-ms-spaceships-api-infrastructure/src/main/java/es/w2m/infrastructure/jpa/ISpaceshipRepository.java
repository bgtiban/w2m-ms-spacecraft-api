package es.w2m.infrastructure.jpa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISpaceshipRepository extends JpaRepository<SpaceshipEntity, Long>{

    Page<SpaceshipEntity> findByNameContainingIgnoreCase(String name, Pageable pageable);
}
