package com.oops.OvertureOfPromachina.application.repository.gameRoomList;

import com.oops.OvertureOfPromachina.application.entity.GameRoom.GameRoom;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.oops.OvertureOfPromachina.application.entity.GameRoom.QGameRoom.gameRoom;

@Repository
class DbGameRoomListRepository implements GameRoomListRepository{

    private final EntityManager em;
    private final JPAQueryFactory query;

    public DbGameRoomListRepository(EntityManager em) {
        this.em = em;
        this.query = new JPAQueryFactory(em);
    }

    @Override
    public List<GameRoom> getGameRoomList(Long page, Long size) {
        return query.select(gameRoom)
                .from(gameRoom)
                .orderBy(gameRoom.createTime.desc(), gameRoom.id.desc())
                .offset(page * size)
                .limit(size)
                .fetch();
    }

    @Override
    public Long getAllGameRoomAmount() {
        return query.select(gameRoom.count())
                .from(gameRoom)
                .fetchOne();
    }
}
