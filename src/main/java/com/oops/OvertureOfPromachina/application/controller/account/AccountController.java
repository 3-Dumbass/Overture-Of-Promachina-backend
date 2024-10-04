package com.oops.OvertureOfPromachina.application.controller.account;

import com.oops.OvertureOfPromachina.application.controller.account.dto.AccountDto;
import com.oops.OvertureOfPromachina.application.controller.user.dto.UserDto;
import com.oops.OvertureOfPromachina.application.entity.account.Account;
import com.oops.OvertureOfPromachina.application.service.business.Account.AccountService;
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

@Tag(name = "account api", description = "지갑계좌 api")
@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;


    /** AccountDto로 들어온 지갑계좌 정보 저장 */
    @Operation(summary = "account-save", description = "유저 계좌 추가 api")
    @PostMapping("/save")
    public ResponseEntity<Boolean> user_account(@RequestBody @Valid AccountDto accountDto) {

        return ResponseEntity.ok()
                .body(accountService.saveAccount(accountDto));

    }


    /** dto는 account 만드는동안 업데이트 예정 */
    @Operation(summary = "account-select", description = "유저 계좌 조회 api")
    @PostMapping("/select")
    public ResponseEntity<UserDto> user_account(@RequestBody @Valid UserDto userDto) {

        List<Account> account = accountService.getAccounts(userDto);
        userDto.setAccount(account);
        return ResponseEntity.ok()
                .body(userDto);
    }

}
