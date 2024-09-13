package com.oops.OvertureOfPromachina.application.responseDto.pagination;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
@Getter
@AllArgsConstructor
public class PaginationResultResponse <T> {
    private List<T> data;
    private Pagination pagination;
}
