package com.oops.OvertureOfPromachina.application.repository.User;

import com.oops.OvertureOfPromachina.application.controller.user.dto.ImageDto;
import com.oops.OvertureOfPromachina.application.entity.user.User;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import static com.oops.OvertureOfPromachina.application.entity.user.QUser.user;

@Repository
@Transactional
@Slf4j
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
    public User userFindByLogin(String login_id) {

        return query.select(user)
                .from(user)
                .where(user.loginId.loginId.eq(login_id))
                .fetchFirst();
    }


    @Override
    public User userFindByNickname(String nickname) {

        return query.select(user)
                .from(user)
                .where(user.nickname.nickname.eq(nickname))
                .fetchFirst();
    }


    @Override
    public User userFind(String login_id, String password) {

        return query.select(user)
                .from(user)
                .where(user.loginId.loginId.eq(login_id), user.pwd.password.eq(password))
                .fetchFirst();
    }


    @Override
    public User userFindById(Long id) {

        return query.select(user)
                .from(user)
                .where(user.id.eq(id))
                .fetchFirst();
    }


    @Override
    public User userImageUpdate(User user_data, String image_path) {
        log.info("Updating user image");
        user_data.setUserImageUrl(image_path);

        return user_data;
    }


}
