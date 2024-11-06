package es.w2m.boot.application;

import es.w2m.api.rest.api.ApiSpaceshipApi;
import es.w2m.api.rest.model.SpaceshipPageDto;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@AllArgsConstructor
public class SpaceshipApiImpl implements ApiSpaceshipApi {

    @Override
    public ResponseEntity<SpaceshipPageDto> searchSpaceships(String name, BigDecimal page, BigDecimal size) {
        return ApiSpaceshipApi.super.searchSpaceships(name, page, size);
    }
}
