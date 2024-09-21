package com.oops.OvertureOfPromachina.application.controller.user;

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
    public ResponseEntity<User> login(User user) {

        User user_data = userService.selectUserData(user.getLoginId().getLoginId(), user.getPwd().getPassword());
        return ResponseEntity.ok()
                .body(user_data);
    }

    @Operation(summary = "find user by nickname", description = "nickname으로 유저 데이터 반환")
    @PostMapping("/user-by-nickname")
    public ResponseEntity<User> user(User user) {

        User user_data = userService.selectUserDataByNickname(user.getNickname().getNickname());
        return ResponseEntity.ok()
                .body(user_data);
    }
}
