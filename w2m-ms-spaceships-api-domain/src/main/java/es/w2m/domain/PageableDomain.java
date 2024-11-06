package es.w2m.domain;

import lombok.*;

import java.util.List;

@Builder
@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageableDomain {
    PageInfoDomain pageInfo;
    List<SpaceshipDomain> spaceships;
}
