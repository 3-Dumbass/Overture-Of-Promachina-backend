package com.oops.OvertureOfPromachina.application.responseDto.pagination;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
@AllArgsConstructor
public class Pagination {
    private Long elementSizeOfPage;
    private Long currentPage;
    private Long totalPage;
    private Long totalElement;
}
