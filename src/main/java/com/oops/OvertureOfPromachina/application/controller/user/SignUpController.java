package com.oops.OvertureOfPromachina.application.controller.user;

import com.oops.OvertureOfPromachina.application.controller.user.dto.SignupDto;
import com.oops.OvertureOfPromachina.application.entity.casinoChip.CasinoChip;
import com.oops.OvertureOfPromachina.application.entity.user.User;
import com.oops.OvertureOfPromachina.application.service.business.CasinoChip.CasinoChipService;
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
@RequestMapping("/api/sign-up")
@RequiredArgsConstructor
public class SignUpController {

    private final UserService userService;
    private final CasinoChipService casinoChipService;

    @Operation(summary = "login id 중복체크", description = "사용 가능한 id 인지 확인")
    @PostMapping("/login-id")
    public ResponseEntity<Boolean> id_check(@RequestBody @Valid SignupDto signupDto) {

        Boolean result = userService.duplicateLoginId(signupDto.getLogin_id());
        return ResponseEntity.ok()
                .body(result);
    }


    @Operation(summary = "ninkname 중복체크", description = "사용 가능한 nickname인지 확인")
    @PostMapping("/nickname")
    public ResponseEntity<Boolean> nickname_check(@RequestBody @Valid SignupDto signupDto) {

        Boolean result = userService.duplicateNickname(signupDto.getNickname());
        return ResponseEntity.ok()
                .body(result);
    }


    @Operation(summary = "user sign up", description = "유저 회원가입 api")
    @PostMapping("/save")
    public ResponseEntity<SignupDto> signup_save(@RequestBody @Valid SignupDto signupDto) {

        Long user_id = userService.save(new User(signupDto.getNickname(), signupDto.getLogin_id(), signupDto.getPassword(), "1"));

        if(user_id != null) {
            User user_data = userService.selectUserData(user_id);
            CasinoChip casinoChip_data = casinoChipService.save(user_data);

            if(casinoChip_data != null) {
                signupDto.setUser_id(user_id);

                return ResponseEntity.ok()
                        .body(signupDto);
            }

        }

        return ResponseEntity.ok()
                .body(null);
    }

}
