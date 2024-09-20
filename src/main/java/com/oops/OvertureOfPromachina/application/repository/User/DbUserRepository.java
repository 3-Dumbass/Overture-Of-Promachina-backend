package com.oops.OvertureOfPromachina.application.repository.User;

import com.oops.OvertureOfPromachina.application.entity.user.User;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import static com.oops.OvertureOfPromachina.application.entity.user.QUser.user;

@Repository
@Transactional
public class DbUserRepository implements UserRepository {

    private final EntityManager em;
    private final JPAQueryFactory query;


    public DbUserRepository(EntityManager em) {
        this.em = em;
        this.query = new JPAQueryFactory(em);
    }


    @Override
    public Long save(User user_save) {

        em.persist(user_save);
        return user_save.getId();
    }

    @Override
    public User user_data_by_login_id(String login_id) {

        return query.select(user)
                .from(user)
                .where(user.loginId.loginId.eq(login_id))
                .fetchFirst();
    }

    @Override
    public User user_data_by_nickname(String nickname) {

        return query.select(user)
                .from(user)
                .where(user.nickname.nickname.eq(nickname))
                .fetchFirst();
    }


}
