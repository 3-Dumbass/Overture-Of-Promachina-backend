package com.oops.OvertureOfPromachina.application.repository.User;

import com.oops.OvertureOfPromachina.application.entity.user.User;

public interface UserRepository {

    /** 회원 가입
     * @param user_save
     * @return LoginId
     * LoginId를 통해 insert 성공여부 확인 */
    Long save(User user_save);

    /** @param login_id
     * @return User */
    User user_data_by_login_id(String login_id);


    /** @param nickname
     * @User */
    User user_data_by_nickname(String nickname);


}
