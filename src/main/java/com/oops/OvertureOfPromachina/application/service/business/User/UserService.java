package com.oops.OvertureOfPromachina.application.service.business.User;

import com.oops.OvertureOfPromachina.application.controller.user.dto.ImageDto;
import com.oops.OvertureOfPromachina.application.controller.user.dto.LoginDto;
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
    public Long save(User user_data){

        return userRepository.save(user_data);
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
    public User loginUserData(LoginDto loginDto){

        User user_data = userRepository.userFind(loginDto.getLogin_id(), loginDto.getPassword());
        return user_data;
    }


    /** nickname 기반 user_data 반환
     * 성공시 user_data
     * 실패시 null */
    public User selectUserData(Long id){

        User user_data = userRepository.userFindById(id);
        return user_data;
    }


    /** 유저 이미지 select
     * @return ImageDto or null */
    public ImageDto selectUserImageData(Long id){

        User user_data = userRepository.userFindById(id);
        return new ImageDto(id, user_data.getUserImageUrl());
    }


    /** 유저 이미지 update
     * @params user_id, image_url
     * @return Boolean */
    public Boolean updateUserImage(Long user_id, String image_url){

        User user_data = userRepository.userFindById(user_id);

        User update_data = userRepository.userImageUpdate(user_data, image_url);

        return update_data.getUserImageUrl().equals(image_url);
    }



}
