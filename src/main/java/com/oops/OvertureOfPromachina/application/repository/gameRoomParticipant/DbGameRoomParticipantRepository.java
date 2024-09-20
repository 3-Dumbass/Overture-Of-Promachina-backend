package com.oops.OvertureOfPromachina.application.repository.gameRoomParticipant;

import com.oops.OvertureOfPromachina.application.entity.GameRoom.GameRoom;
import com.oops.OvertureOfPromachina.application.entity.gameRoomParticipant.GameRoomParticipant;
import com.oops.OvertureOfPromachina.application.entity.user.User;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import static com.oops.OvertureOfPromachina.application.entity.gameRoomParticipant.QGameRoomParticipant.gameRoomParticipant;

@Repository
public class DbGameRoomParticipantRepository implements GameRoomParticipantRepository {
    private final EntityManager em;
    private final JPAQueryFactory query;

    public DbGameRoomParticipantRepository(EntityManager em) {
        this.em = em;
        this.query = new JPAQueryFactory(em);
    }

    @Override
    public Long save(GameRoomParticipant gameRoomParticipant) {
        em.persist(gameRoomParticipant);
        return gameRoomParticipant.getId();
    }

    @Override
    public void removeByUser(User user) {
        query.delete(gameRoomParticipant)
                .where(gameRoomParticipant.user.eq(user))
                .execute();
    }

    @Override
    public GameRoom findByUser(User user) {
        return query.select(gameRoomParticipant.gameRoom)
                .from(gameRoomParticipant)
                .where(gameRoomParticipant.user.eq(user))
                .fetchOne();
    }
}
