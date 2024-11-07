package es.w2m.rest;

import es.w2m.api.rest.model.PageInfoDto;
import es.w2m.api.rest.model.SpaceshipDto;
import es.w2m.api.rest.model.SpaceshipPageDto;
import es.w2m.domain.model.PageInfoDomainModel;
import es.w2m.domain.model.PageableDomainModel;
import es.w2m.domain.model.SpaceshipDomainModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.math.BigDecimal;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ISpaceShipPageableMapperApp {

    @Mapping(target = "id", source = "id", qualifiedByName = "bigDecimalToLong")
    SpaceshipDto toDto(SpaceshipDomainModel spaceshipDomain);

    List<SpaceshipDto> toDtoList(List<SpaceshipDomainModel> spaceshipDomainList);

    PageInfoDto toDto(PageInfoDomainModel pageInfoDomain);

    SpaceshipPageDto toDto(PageableDomainModel pageableDomain);

    SpaceshipDomainModel toDomain(SpaceshipDto spaceshipDto);

    @Named("bigDecimalToLong")
    default BigDecimal bigDecimalToLong(Long id) {
        return id != null ? BigDecimal.valueOf(id) : null;
    }
}
