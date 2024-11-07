package es.w2m.domain;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class SpaceshipValidationAspect {

    @Before(value = "execution(* es.w2m.domain.ISpaceshipService.searchSpaceshipById(Long)) && args(id)")
    public void validateId(Long id) {
        if(id == null || id < 0) {
            log.warn("Id menor que 0, debe ser mayor o igual, id recibido: {}", id);
            throw new IllegalArgumentException("El ID no puede ser menor que 0");
        }
    }
}
