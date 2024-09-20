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

        String insert_check = userRepository.save(new User(login_id, Password, Nickname, Account, PriKey));
        return insert_check != null;
    }


    /** login_id 중복체크
     * 성공시 true
     * 실패시 false 반환 */
    public Boolean duplicateLoginId(String login_id){

        return null == userRepository.loginIdByLoginId(login_id);
    }


    /** nickname 중복체크
     * 성공시 true
     * 실패시 false 반환 */
    public Boolean duplicateNickname(String nickname){

        return null == userRepository.nicknameByNickname(nickname);
    }


    /** login_id 기반 nickname 반환
     * 성공시 nickname
     * 실패시 null */
    public String findNicknameByLoginId(String login_id){

        return userRepository.nicknameByLoginId(login_id);
    }


    /** nickname 기반 account,priKey 반환
     *  성공시 Pair<account, priKey>
     *  실패시 flase */
    public Pair<String, String> findAccountAndPriKeyByNickname(String nickname){

        return Pair.of(userRepository.accountByNickname(nickname), userRepository.priKeyByNickname(nickname));
    }
}
