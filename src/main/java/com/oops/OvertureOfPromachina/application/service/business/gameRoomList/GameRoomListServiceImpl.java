package com.oops.OvertureOfPromachina.application.service.business.gameRoomList;

import com.oops.OvertureOfPromachina.application.responseDto.gameRoomList.GameRoomMetadataResponse;
import com.oops.OvertureOfPromachina.application.responseDto.pagination.Pagination;
import com.oops.OvertureOfPromachina.application.responseDto.pagination.PaginationResultResponse;
import com.oops.OvertureOfPromachina.application.repository.gameRoomList.GameRoomListRepository;
import com.oops.OvertureOfPromachina.application.service.domain.pagination.PaginationDomainLogic;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
class GameRoomListServiceImpl implements GameRoomListService{

    private final GameRoomListRepository gameRoomListRepository;
    private final PaginationDomainLogic paginationDomainLogic;

    @Override
    public PaginationResultResponse<GameRoomMetadataResponse> getGameRoomList(Long page, Long size) {
        List<GameRoomMetadataResponse> gameRoomList = gameRoomListRepository.getGameRoomList(page, size).stream()
                .map(e -> new GameRoomMetadataResponse(
                        e.getId(),
                        e.getTitle().getTitle(),
                        e.getGameMode().getGameMode(),
                        e.getCreateTime())
                ).toList();

        Long totalElement = gameRoomListRepository.getAllGameRoomAmount();
        Long totalPage = paginationDomainLogic.calcTotalPage(totalElement, size);


        return new PaginationResultResponse<GameRoomMetadataResponse>(
                gameRoomList,
                new Pagination(size, page, totalPage, totalElement)
        );
    }
}
