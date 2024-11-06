package es.w2m;

import es.w2m.api.rest.api.ApiSpaceshipApi;
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
}
