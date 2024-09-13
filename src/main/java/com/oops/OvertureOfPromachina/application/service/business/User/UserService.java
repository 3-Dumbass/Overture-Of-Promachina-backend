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
    public Boolean save(String LoginId, String Password, String Nickname, String Account, String PriKey){

        String insert_check = userRepository.save(new User(LoginId, Password, Nickname, Account, PriKey));
        return insert_check != null;
    }


    public Boolean DuplicateLoginId(String LoginId){

        return userRepository.DuplicateCheckUser(LoginId);
    }


    public Boolean DuplicateNickname(String Nickname){

        return userRepository.DuplicateCheckNickname(Nickname);
    }


    public String FindNicknameByLoginId(String LoginId){

        return userRepository.FindNicknameByLoginID(LoginId);
    }


    public Pair<String, String> FindAccountAndPriKeyByNickname(String Nickname){

        return userRepository.FindAccountAndPriKeyByNickname(Nickname);
    }
}
