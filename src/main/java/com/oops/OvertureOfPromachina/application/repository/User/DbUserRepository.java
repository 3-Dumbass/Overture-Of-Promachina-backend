package com.oops.OvertureOfPromachina.application.repository.User;

import com.oops.OvertureOfPromachina.application.entity.user.User;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Repository;
import com.querydsl.jpa.impl.JPAQueryFactory;
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
    public String save(User user_save) {

        em.persist(user_save);
        return  query.select(user.loginId.loginId)
                .from(user)
                .where(user.loginId.loginId.eq(user_save.getLoginId().getLoginId()))
                .fetchOne();
    }


    /** LoginId 중복체크 */
    @Override
    public String loginIdByLoginId(String login_id) {

        return query.select(user.loginId.loginId)
                .from(user)
                .where(user.loginId.loginId.eq(login_id))
                .fetchOne();
    }


    /** Nickname 중복체크 */
    @Override
    public String nicknameByNickname(String nickname) {

        return query.select(user.nickname.nickname)
                .from(user)
                .where(user.nickname.nickname.eq(nickname))
                .fetchOne();
    }


    /** login_id 기반 nickname 반환 */
    @Override
    public String nicknameByLoginId(String login_id) {

        return query.select(user.nickname.nickname)
                .from(user)
                .where(user.loginId.loginId.eq(login_id))
                .fetchOne();
    }


    /** Nickname 기반 지갑주소 반환 */
    @Override
    public String accountByNickname(String nickname) {

        return query.select(user.account.account)
                .from(user)
                .where(user.nickname.nickname.eq(nickname))
                .fetchOne();
    }

    /** Nickname 기반 개인키 반환 */
    @Override
    public String priKeyByNickname(String nickname) {

        return query.select(user.priKey.privateKey)
                .from(user)
                .where(user.nickname.nickname.eq(nickname))
                .fetchOne();
    }

}
