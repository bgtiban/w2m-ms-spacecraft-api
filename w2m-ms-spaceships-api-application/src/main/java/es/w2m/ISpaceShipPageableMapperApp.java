package es.w2m;

import es.w2m.api.rest.model.PageInfoDto;
import es.w2m.api.rest.model.SpaceshipDto;
import es.w2m.api.rest.model.SpaceshipPageDto;
import es.w2m.domain.PageInfoDomain;
import es.w2m.domain.PageableDomain;
import es.w2m.domain.SpaceshipDomain;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.math.BigDecimal;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ISpaceShipPageableMapperApp {

    @Mapping(target = "id", source = "id", qualifiedByName = "bigDecimalToLong")
    SpaceshipDto toDto(SpaceshipDomain spaceshipDomain);

    List<SpaceshipDto> toDtoList(List<SpaceshipDomain> spaceshipDomainList);

    PageInfoDto toDto(PageInfoDomain pageInfoDomain);

    SpaceshipPageDto toDto(PageableDomain pageableDomain);

    @Named("bigDecimalToLong")
    default BigDecimal bigDecimalToLong(Long id) {
        return id != null ? BigDecimal.valueOf(id) : null;
    }
}
