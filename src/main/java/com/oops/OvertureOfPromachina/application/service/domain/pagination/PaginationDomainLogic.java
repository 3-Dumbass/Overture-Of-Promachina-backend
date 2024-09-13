package com.oops.OvertureOfPromachina.application.service.domain.pagination;

import org.springframework.stereotype.Component;

@Component
public class PaginationDomainLogic {
    public Long calcTotalPage(Long totalElement,Long size){
        return (totalElement + size - 1) / size;
    }
}
