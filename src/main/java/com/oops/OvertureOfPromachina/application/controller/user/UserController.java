package com.oops.OvertureOfPromachina.application.controller.user;

import com.oops.OvertureOfPromachina.application.controller.user.dto.ImageDto;
import com.oops.OvertureOfPromachina.application.controller.user.dto.UserDto;
import com.oops.OvertureOfPromachina.application.entity.account.Account;
import com.oops.OvertureOfPromachina.application.entity.user.User;
import com.oops.OvertureOfPromachina.application.service.business.Account.AccountService;
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

import java.util.List;

@Tag(name = "User api", description = "유저 정보 api")
@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final AccountService accountService;

    /** dto는 account 만드는동안 업데이트 예정 */
    @Operation(summary = "user-account", description = "유저 계좌 조회 api")
    @PostMapping("/account")
    public ResponseEntity<UserDto> user_account(@RequestBody @Valid UserDto userDto) {

        List<Account> account = accountService.getAccounts(userDto);
        return ResponseEntity.ok()
                .body(new UserDto(userDto.getId(), account));
    }


    @Operation(summary = "user-image", description = "유저 이미지 조회 api")
    @PostMapping("/image")
    public ResponseEntity<ImageDto> user_info(@RequestBody @Valid UserDto userDto) {

        return ResponseEntity.ok()
                .body(userService.selectUserImageData(userDto.getId()));
    }
}
