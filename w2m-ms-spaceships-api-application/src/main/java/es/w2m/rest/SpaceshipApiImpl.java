package es.w2m.rest;

import es.w2m.api.rest.api.ApiSpaceshipApi;
import es.w2m.api.rest.model.CreateSpaceshipDto;
import es.w2m.api.rest.model.SpaceshipDto;
import es.w2m.api.rest.model.SpaceshipPageDto;
import es.w2m.domain.ISpaceshipService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@AllArgsConstructor
public class SpaceshipApiImpl implements ApiSpaceshipApi {

    @Autowired
    ISpaceshipService service;

    @Autowired
    ISpaceShipPageableMapperApp mapper;

    @Override
    public ResponseEntity<SpaceshipPageDto> searchSpaceships(String name, BigDecimal page, BigDecimal size) {
        return ResponseEntity.ok(mapper
                .toDto(service.searchSpaceships(name, page.intValue(), size.intValue())));
    }

    @Override
    public ResponseEntity<SpaceshipDto> getSpaceshipById(BigDecimal spaceshipId) {
        return ResponseEntity.ok(mapper
                .toDto(service.searchSpaceshipById(spaceshipId.longValue())));
    }

    @Override
    public ResponseEntity<SpaceshipDto> createSpaceship(CreateSpaceshipDto spaceshipDto) {
        return ResponseEntity.ok(mapper
                .toDto(service.createSpaceship(mapper.toDomain(spaceshipDto))));
    }

    @Override
    public ResponseEntity<SpaceshipDto> updateSpaceship(SpaceshipDto spaceshipDto) {
        return ResponseEntity.ok(mapper
                .toDto(service.updateSpaceship(mapper.toDomain(spaceshipDto))));
    }

    @Override
    public ResponseEntity<Void> deleteSpaceship(BigDecimal spaceshipId) {
        service.deleteSpaceshipById(spaceshipId.longValue());
        return ResponseEntity.ok().build();
    }
}
