package es.w2m.infrastructure.jpa;

import es.w2m.domain.PageInfoDomain;
import es.w2m.domain.PageableDomain;
import es.w2m.domain.SpaceshipDomain;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ISpaceShipPageableMapperInfra {

    SpaceshipDomain toDomain(SpaceshipEntity spaceshipEntity);

    List<SpaceshipDomain> toDomainList(List<SpaceshipEntity> entities);

    @Mapping(target = "pageNumber", source = "number")
    @Mapping(target = "pageSize", source = "size")
    @Mapping(target = "totalPages", expression = "java((long) page.getTotalPages())")
    @Mapping(target = "totalSize",expression = "java((long) page.getTotalElements())")
    PageInfoDomain toPageInfo(Page<SpaceshipEntity> page);

    @Mapping(target = "spaceships", source = "content")
    @Mapping(target = "pageInfo", source = ".")
    PageableDomain toPageableDomain(Page<SpaceshipEntity> page);
}
