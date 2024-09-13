package com.oops.OvertureOfPromachina.application.repository.gameRoom;

import com.oops.OvertureOfPromachina.application.entity.GameRoom.GameRoom;
import com.oops.OvertureOfPromachina.application.entity.user.User;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import static com.oops.OvertureOfPromachina.application.entity.gameRoomParticipant.QGameRoomParticipant.gameRoomParticipant;

@Repository
class DbGameRoomRepository implements GameRoomRepository{

    private final EntityManager em;
    private final JPAQueryFactory query;

    public DbGameRoomRepository(EntityManager em) {
        this.em = em;
        this.query = new JPAQueryFactory(em);
    }

    @Override
    public Long save(GameRoom gameRoom) {
        em.persist(gameRoom);
        return gameRoom.getId();
    }

    @Override
    public void remove(GameRoom gameRoom) {
        em.remove(gameRoom);
    }

    @Override
    public GameRoom findById(Long id) {
        return em.find(GameRoom.class, id);
    }

    @Override
    public GameRoom findByUser(User user) {
        return query.select(gameRoomParticipant.gameRoom)
                .from(gameRoomParticipant)
                .where(gameRoomParticipant.user.eq(user))
                .fetchOne();
    }
}
