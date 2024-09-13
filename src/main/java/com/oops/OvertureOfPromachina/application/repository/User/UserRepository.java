package com.oops.OvertureOfPromachina.application.repository.User;

import com.oops.OvertureOfPromachina.application.entity.user.User;
import org.springframework.data.util.Pair;

public interface UserRepository {

    /** 회원 가입
     * @param user
     * @return LoginId
     * LoginId를 통해 insert 성공여부 확인 */
    String save(User user);


    /** 중복 ID 체크
     * @param LoginId
     * @return Null or LoginId*/
    Boolean DuplicateCheckUser(String LoginId);


    /** 중복 Nickname 체크
     * @param Nickname
     * @return Null or Nickname*/
    Boolean DuplicateCheckNickname(String Nickname);


    /** 인게임에서 사용할 Nickname 반환
     * @param LoginId
     * @return Nickname*/
    String FindNicknameByLoginID(String LoginId);


    /** 코인 교환시 사용할 지갑주소 및 개인키 반환
     * @param Nickname
     * return Pair<Account, priKey></>*/
    Pair<String, String> FindAccountAndPriKeyByNickname(String Nickname);
}
