package com.oops.OvertureOfPromachina.application.repository.User;

import com.oops.OvertureOfPromachina.application.entity.user.User;

public interface UserRepository {

    /** 회원 가입
     * @param user_save
     * @return LoginId
     * LoginId를 통해 insert 성공여부 확인 */
    String save(User user_save);


    /** LoginId 중복체크
     * @param login_id
     * @return Null or LoginId*/
    String loginIdByLoginId(String login_id);


    /** Nickname 중복체크
     * @param nickname
     * @return Null or Nickname*/
    String nicknameByNickname(String nickname);


    /** login_id 기반 nickname 반환
     * @param login_id
     * @return Nickname*/
    String nicknameByLoginId(String login_id);


    /** Nickname 기반 지갑주소 반환
     * @param nickname
     * return account*/
    String accountByNickname(String nickname);


    /** Nickname 기반 개인키 반환
     * @param nickname
     * return priKey*/
    String priKeyByNickname(String nickname);


}
