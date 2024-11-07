package es.w2m.domain.model;

import lombok.*;

import java.util.List;

@Builder
@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageableDomainModel {
    PageInfoDomainModel pageInfo;
    List<SpaceshipDomainModel> spaceships;
}
