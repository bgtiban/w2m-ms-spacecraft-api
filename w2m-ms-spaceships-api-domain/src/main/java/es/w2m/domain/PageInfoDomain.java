package es.w2m.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PageInfoDomain {
    Integer pageNumber;
    Integer pageSize;
    Long totalPages;
    Long totalSize;
}