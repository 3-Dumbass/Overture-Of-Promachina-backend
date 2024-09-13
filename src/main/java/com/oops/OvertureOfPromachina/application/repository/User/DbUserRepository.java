package com.oops.OvertureOfPromachina.application.repository.User;

import com.oops.OvertureOfPromachina.application.entity.user.User;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Repository;
import com.querydsl.jpa.impl.JPAQueryFactory;

import static com.oops.OvertureOfPromachina.application.entity.user.QUser.user;

@Repository
@RequiredArgsConstructor
public class DbUserRepository implements UserRepository {

    private final EntityManager em;
    private final JPAQueryFactory query = new JPAQueryFactory(em);

    @Override
    public String save(User user_save) {

        em.persist(user_save);

        return  query.select(user.loginId.loginId)
                .from(user)
                .where(user.loginId.loginId.eq(user_save.getLoginId().getLoginId()))
                .fetchOne();
    }


    /** 회원가입 LoginId 중복체크 */
    @Override
    public Boolean DuplicateCheckUser(String login_id) {

        String userLoginId = query.select(user.loginId.loginId)
                .from(user)
                .where(user.loginId.loginId.eq(login_id))
                .fetchOne();

        return null == userLoginId;
    }


    /** 회원가입 Nickname 중복체크 */
    @Override
    public Boolean DuplicateCheckNickname(String nickname) {

        String userLoginId = query.select(user.nickname.nickname)
                .from(user)
                .where(user.nickname.nickname.eq(nickname))
                .fetchOne();

        return null == userLoginId;
    }


    /** 로그인 시 User의 Nickname 반환 후 해당 데이터 사용 */
    @Override
    public String FindNicknameByLoginID(String login_id) {

        return query.select(user.nickname.nickname)
                .from(user)
                .where(user.loginId.loginId.eq(login_id))
                .fetchOne();
    }


    /** 플레이중 Nickname 기반 코인 교환시 필요한 지갑주소와 개인키 반환 */
    @Override
    public Pair<String, String> FindAccountAndPriKeyByNickname(String nickname) {

        String login_id = query.select(user.loginId.loginId)
                .from(user)
                .where(user.nickname.nickname.eq(nickname))
                .fetchOne();

        String priKey = query.select(user.priKey.privateKey)
                .from(user)
                .where(user.nickname.nickname.eq(nickname))
                .fetchOne();

        return Pair.of(login_id, priKey);
    }
}
