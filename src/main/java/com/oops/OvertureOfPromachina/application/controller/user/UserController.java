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


    @Operation(summary = "user image select", description = "유저 이미지 조회 api")
    @PostMapping("/image-select")
    public ResponseEntity<UserDto> user_image_select(@RequestBody @Valid UserDto userDto) {

        String image_url = userService.selectUserImage(userDto);
        userDto.setImage_url(image_url);

        return ResponseEntity.ok()
                .body(userDto);
    }


    @Operation(summary = "user image update", description = "유저 이미지 수정 api")
    @PostMapping("/image-update")
    public ResponseEntity<Boolean> user_image_update(@RequestBody @Valid UserDto userDto) {

        return ResponseEntity.ok()
                .body(userService.updateUserImage(userDto.getUser_id(), userDto.getImage_url()));
    }
}
