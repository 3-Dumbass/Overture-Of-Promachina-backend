package com.oops.OvertureOfPromachina.application.repository.CasinoChip;

import com.oops.OvertureOfPromachina.application.entity.casinoChip.CasinoChip;
import com.oops.OvertureOfPromachina.application.entity.user.User;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import static com.oops.OvertureOfPromachina.application.entity.casinoChip.QCasinoChip.casinoChip;

@Repository
@Transactional
public class DBCasinoChipRepository implements CasinoChipRepository{

    private final EntityManager em;
    private final JPAQueryFactory query;


    public DBCasinoChipRepository(EntityManager em) {
        this.em = em;
        this.query = new JPAQueryFactory(em);
    }


    @Override
    public CasinoChip save(CasinoChip casinoChip_data) {

        em.persist(casinoChip_data);
        return selectById(casinoChip_data.getUser_id().getId());
    }


    @Override
    public CasinoChip update(User user_data, long rate) {

        query.update(casinoChip)
            .set(casinoChip.money, casinoChip.money.add(rate))
            .where(casinoChip.user_id.id.eq(user_data.getId()));

        return selectById(user_data.getId());
    }


    @Override
    public CasinoChip selectById(long id) {

        return query.select(casinoChip)
                .from(casinoChip)
                .where(casinoChip.user_id.id.eq(id))
                .fetchFirst();
    }
}
