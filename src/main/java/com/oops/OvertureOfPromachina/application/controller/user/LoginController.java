package com.oops.OvertureOfPromachina.application.controller.user;

import com.oops.OvertureOfPromachina.application.controller.user.dto.LoginDto;
import com.oops.OvertureOfPromachina.application.controller.user.dto.UserDto;
import com.oops.OvertureOfPromachina.application.entity.user.User;
import com.oops.OvertureOfPromachina.application.service.business.User.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Login api", description = "로그인 api")
@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {

    private final UserService userService;


    @Operation(summary = "login", description = "로그인")
    @PostMapping("/login")
    public ResponseEntity<UserDto> login(LoginDto loginData) {

        // login 시 있는 유저인지 확인
        User user_data = userService.loginUserData(loginData);

        if (user_data == null) {
            return ResponseEntity.ok()
                    .body(null);
        }
        else {
            // account와 priKey를 userDto에 넣어 return
            UserDto userDto = new UserDto(user_data.getId(), "test_account", "test_priKey");
            return ResponseEntity.ok()
                    .body(userDto);
        }
    }

}
