package com.oops.OvertureOfPromachina.application.controller.user;

import com.oops.OvertureOfPromachina.application.controller.user.dto.LoginDto;
import com.oops.OvertureOfPromachina.application.entity.user.User;
import com.oops.OvertureOfPromachina.application.entity.user.valueObject.UserAccount;
import com.oops.OvertureOfPromachina.application.entity.user.valueObject.UserPrivateKey;
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
@RequestMapping("/sign-up")
@RequiredArgsConstructor
public class SignUpController {

    private final UserService userService;


    @Operation(summary = "login id 중복체크", description = "사용 가능한 id 인지 확인")
    @PostMapping("/login-id")
    public ResponseEntity<Boolean> id_check(@RequestBody @Valid LoginDto loginDto) {

        Boolean result = userService.duplicateLoginId(loginDto.getLogin_id());
        return ResponseEntity.ok()
                .body(result);
    }


    @Operation(summary = "ninkname 중복체크", description = "사용 가능한 nickname인지 확인")
    @PostMapping("/nickname")
    public ResponseEntity<Boolean> nickname_check(@RequestBody @Valid LoginDto loginDto) {

        Boolean result = userService.duplicateNickname(loginDto.getNickname());
        return ResponseEntity.ok()
                .body(result);
    }


    @Operation(summary = "user sign up", description = "유저 회원가입 api")
    @PostMapping("/save")
    public ResponseEntity<Boolean> signup_check(@RequestBody @Valid LoginDto loginDto) {

        Boolean result = userService.save(new User(loginDto.getLogin_id(), loginDto.getNickname(), loginDto.getPassword()));
        return ResponseEntity.ok()
                .body(result);
    }

}
