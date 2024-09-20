package com.oops.OvertureOfPromachina.application.service.business.User;

import com.oops.OvertureOfPromachina.application.entity.user.User;
import com.oops.OvertureOfPromachina.application.repository.User.UserRepository;
import lombok.RequiredArgsConstructor;
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
    public Boolean save(User user_data){

        Long insert_check = userRepository.save(user_data);
        return insert_check != null;
    }


    /** login_id 중복체크
     * 성공시 true
     * 실패시 false 반환 */
    public Boolean duplicateLoginId(String login_id){

        User login_check = userRepository.userFindByLogin(login_id);
        return null == login_check;
    }


    /** nickname 중복체크
     * 성공시 true
     * 실패시 false 반환 */
    public Boolean duplicateNickname(String nickname){

        User nickname_check = userRepository.userFindByNickname(nickname);
        return null == nickname_check;
    }


    /** login_id, password 기반 user_data 반환
     * 성공시 user_data
     * 실패시 null */
    public User selectUserData(String login_id, String password){

        User user_data = userRepository.userFind(login_id, password);
        return user_data;
    }


    /** nickname 기반 user_data 반환
     * 성공시 user_data
     * 실패시 null */
    public User selectUserDataByNickname(String nickname){

        User user_data = userRepository.userFindByNickname(nickname);
        return user_data;
    }

}
