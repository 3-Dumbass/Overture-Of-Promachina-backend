package com.oops.OvertureOfPromachina.application.controller.user;

import com.oops.OvertureOfPromachina.application.controller.user.dto.UserDto;
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

@Tag(name = "User api", description = "유저 정보 api")
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /** dto는 account 만드는동안 업데이트 예정 */
    @Operation(summary = "user-account", description = "id 값을 통해 userDto 반환")
    @PostMapping("/account")
    public ResponseEntity<UserDto> user_account(@RequestBody @Valid UserDto userDto) {

        User user_data = userService.selectUserData(userDto.getId());

        if (user_data == null) {
            return ResponseEntity.ok()
                    .body(null);
        }
        else {
            return ResponseEntity.ok()
                    .body(new UserDto(user_data.getId(), user_data.getAccount().getAccount(), user_data.getPriKey().getPrivateKey()));
        }
    }
}
