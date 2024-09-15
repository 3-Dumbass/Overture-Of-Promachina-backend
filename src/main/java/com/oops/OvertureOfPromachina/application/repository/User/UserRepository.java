package com.oops.OvertureOfPromachina.application.repository.User;

import com.oops.OvertureOfPromachina.application.entity.user.User;
import org.springframework.data.util.Pair;

public interface UserRepository {

    /** 회원 가입
     * @param user_save
     * @return LoginId
     * LoginId를 통해 insert 성공여부 확인 */
    String save(User user_save);


    /** 중복 ID 체크
     * @param login_id
     * @return Null or LoginId*/
    Boolean DuplicateCheckUser(String login_id);


    /** 중복 Nickname 체크
     * @param nickname
     * @return Null or Nickname*/
    Boolean DuplicateCheckNickname(String nickname);


    /** 인게임에서 사용할 Nickname 반환
     * @param login_id
     * @return Nickname*/
    String FindNicknameByLoginId(String login_id);


    /** 코인 교환시 사용할 지갑주소 및 개인키 반환
     * @param nickname
     * return Pair<Account, priKey></>*/
    Pair<String, String> FindAccountAndPriKeyByNickname(String nickname);
}
