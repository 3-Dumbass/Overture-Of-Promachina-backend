package com.oops.OvertureOfPromachina.application.controller.user;

import com.oops.OvertureOfPromachina.application.entity.user.User;
import com.oops.OvertureOfPromachina.application.service.business.User.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "sign up api", description = "회원가입 api")
@RestController
@RequestMapping("/signup")
@RequiredArgsConstructor
public class SignUpController {


    private final UserService userService;

    @Operation(summary = "id 중복체크", description = "사용 가능한 id 인지 확인")
    @PostMapping("/id")
    public ResponseEntity<Boolean> id_check(@RequestBody @Valid User user_data) {
        Boolean result = userService.duplicateLoginId(user_data.getLoginId().getLoginId());
        return ResponseEntity.ok()
                .body(result);
    }


    @Operation(summary = "ninkname 중복체크", description = "사용 가능한 nickname인지 확인")
    @PostMapping("/nickname")
    public ResponseEntity<Boolean> nickname_check(@RequestBody @Valid User user_data) {
        Boolean result = userService.duplicateNickname(user_data.getNickname().getNickname());
        return ResponseEntity.ok()
                .body(result);
    }




}
