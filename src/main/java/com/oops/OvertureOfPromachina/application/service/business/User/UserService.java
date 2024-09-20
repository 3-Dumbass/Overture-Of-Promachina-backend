package com.oops.OvertureOfPromachina.application.service.business.User;

import com.oops.OvertureOfPromachina.application.entity.user.User;
import com.oops.OvertureOfPromachina.application.repository.User.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    /** user 데이터 저장
     * 성공시 true
     * 실패시 false 반환 */
    public Boolean save(String login_id, String Password, String Nickname, String Account, String PriKey){

        Long insert_check = userRepository.save(new User(login_id, Password, Nickname, Account, PriKey));
        return insert_check != null;
    }


    /** login_id 중복체크
     * 성공시 true
     * 실패시 false 반환 */
    public Boolean duplicateLoginId(String login_id){

        User login_check = userRepository.user_data_by_login_id(login_id);

        return null == login_check;
    }


    /** nickname 중복체크
     * 성공시 true
     * 실패시 false 반환 */
    public Boolean duplicateNickname(String nickname){

        User nickname_check = userRepository.user_data_by_nickname(nickname);

        return null == nickname_check;
    }


    /** login_id 기반 user_data 반환
     * 성공시 user_data
     * 실패시 null */
    public User select_user_data(String login_id){

        User user_data = userRepository.user_data_by_login_id(login_id);

        return user_data;
    }

}
