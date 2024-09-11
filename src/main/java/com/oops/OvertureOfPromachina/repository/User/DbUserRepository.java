package com.oops.OvertureOfPromachina.repository.User;

import com.oops.OvertureOfPromachina.application.entity.user.User;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class DbUserRepository implements UserRepository {

    private final EntityManager em;


    @Override
    public String save(User user) {
        em.persist(user);

        User user_insert = em.find(User.class, user.getId());
        return  user_insert.getLoginId().toString();
    }


    /** 회원가입 LoginId 중복체크 */
    @Override
    public String DuplicateCheckUser(String LoginId) {

        User user = em.find(User.class, LoginId);
        return user.getLoginId().toString();
    }


    /** 회원가입 Nickname 중복체크 */
    @Override
    public String DuplicateCheckNickname(String Nickname) {

        User user = em.find(User.class, Nickname);
        return user.getNickname().toString();
    }


    /** 로그인 시 User의 Nickname 반환 후 해당 데이터 사용 */
    @Override
    public String FindNicknameByLoginID(String LoginId) {

        User user = em.find(User.class, LoginId);
        return user.getNickname().toString();
    }


    /** 플레이중 Nickname 기반 코인 교환시 필요한 지갑주소와 개인키 반환 */
    @Override
    public Pair<String, String> FindAccountAndPriKeyByNickname(String Nickname) {

        User user = em.find(User.class, Nickname);
        return Pair.of(user.getAccount().toString(), user.getPriKey().toString());
    }
}
