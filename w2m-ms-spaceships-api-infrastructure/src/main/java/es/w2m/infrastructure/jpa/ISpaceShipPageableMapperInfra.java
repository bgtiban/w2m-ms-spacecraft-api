package es.w2m.infrastructure.jpa;

import es.w2m.domain.model.PageInfoDomainModel;
import es.w2m.domain.model.PageableDomainModel;
import es.w2m.domain.model.SpaceshipDomainModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ISpaceShipPageableMapperInfra {

    SpaceshipDomainModel toDomain(SpaceshipEntity spaceshipEntity);

    List<SpaceshipDomainModel> toDomainList(List<SpaceshipEntity> entities);

    @Mapping(target = "pageNumber", source = "number")
    @Mapping(target = "pageSize", source = "size")
    @Mapping(target = "totalPages", expression = "java((long) page.getTotalPages())")
    @Mapping(target = "totalSize",expression = "java((long) page.getTotalElements())")
    PageInfoDomainModel toPageInfo(Page<SpaceshipEntity> page);

    @Mapping(target = "spaceships", source = "content")
    @Mapping(target = "pageInfo", source = ".")
    PageableDomainModel toPageableDomain(Page<SpaceshipEntity> page);

    SpaceshipEntity toEntity(SpaceshipDomainModel newSpaceship);
}
