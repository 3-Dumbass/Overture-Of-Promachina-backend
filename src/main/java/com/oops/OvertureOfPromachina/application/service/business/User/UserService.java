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

    /** 유저 정보 저장
     * 저장 성공시 True 반환 */
    public Boolean save(String login_id, String password, String nickname, String account, String priKey){

        String insert_check = userRepository.save(new User(login_id, password, nickname, account, priKey));
        return insert_check != null;
    }


    public Boolean DuplicateLoginId(String login_id){

        return userRepository.DuplicateCheckUser(login_id);
    }


    public Boolean DuplicateNickname(String nickname){

        return userRepository.DuplicateCheckNickname(nickname);
    }


    public String FindNicknameByLoginId(String login_id){

        return userRepository.FindNicknameByLoginID(login_id);
    }


    public Pair<String, String> FindAccountAndPriKeyByNickname(String nickname){

        return userRepository.FindAccountAndPriKeyByNickname(nickname);
    }
}
