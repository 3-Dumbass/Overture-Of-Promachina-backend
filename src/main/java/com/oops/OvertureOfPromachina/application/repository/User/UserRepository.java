package com.oops.OvertureOfPromachina.application.repository.User;

import com.oops.OvertureOfPromachina.application.entity.user.User;

public interface UserRepository {

    /** 회원 가입
     * LoginId를 통해 insert 성공여부 확인
     * @params user_save
     * @return LoginId */
    Long save(User user_save);





    /** @params login_id, password
     * @return User */
    User userFind(String login_id, String password);


    /** @params login_id
     * @return User */
    User userFindByLogin(String login_id);


    /** @params nickname
     * @return User */
    User userFindByNickname(String nickname);


    /** @params user_id
     * @return User */
    User userFindById(Long user_id);


    /** @params user_data */
    User userImageUpdate(User user_data, String image_path);
}
