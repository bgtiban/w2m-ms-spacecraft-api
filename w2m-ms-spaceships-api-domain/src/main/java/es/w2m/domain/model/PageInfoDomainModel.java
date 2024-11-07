package es.w2m.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PageInfoDomainModel {
    Integer pageNumber;
    Integer pageSize;
    Long totalPages;
    Long totalSize;
}