package com.oops.OvertureOfPromachina.application.repository.CasinoChip;

import com.oops.OvertureOfPromachina.application.entity.casinoChip.CasinoChip;
import com.oops.OvertureOfPromachina.application.entity.user.User;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.logging.Logger;

import static com.oops.OvertureOfPromachina.application.entity.casinoChip.QCasinoChip.casinoChip;

@Repository
@Transactional
@Slf4j
public class DBCasinoChipRepository implements CasinoChipRepository{

    private final EntityManager em;
    private final JPAQueryFactory query;


    public DBCasinoChipRepository(EntityManager em) {
        this.em = em;
        this.query = new JPAQueryFactory(em);
    }


    @Override
    public Long save(CasinoChip casinoChip_data) {

        em.persist(casinoChip_data);
        return casinoChip_data.getCasino_chip_id();
    }


    @Override
    public CasinoChip update(User user_data, Long money) {

        CasinoChip casinoChip = selectById(user_data.getId());
        if (casinoChip != null) {
            casinoChip.setMoney(money);
            return casinoChip;
        }
        else {
            return null;
        }
    }


    @Override
    public CasinoChip selectById(Long id) {

        return query.select(casinoChip)
                .from(casinoChip)
                .where(casinoChip.user_id.id.eq(id))
                .fetchOne();
    }
}
