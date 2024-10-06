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

import java.util.ArrayList;
import java.util.List;

@Tag(name = "account api", description = "지갑계좌 api")
@RestController
@RequestMapping("/api/account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;


    @Operation(summary = "account-save", description = "유저 계좌 추가 api")
    @PostMapping("/add")
    public ResponseEntity<Boolean> account_add(@RequestBody @Valid AccountDto accountDto) {

        return ResponseEntity.ok()
                .body(accountService.saveAccount(accountDto));

    }


    @Operation(summary = "account-select", description = "유저 계좌 조회 api")
    @PostMapping("/select")
    public ResponseEntity<UserDto> account_select(@RequestBody @Valid UserDto userDto) {

        List<Account> account = accountService.getAccounts(userDto);
        List<AccountDto> accountDto = new ArrayList<AccountDto>();

        for (Account a : account) {
            accountDto.add(new AccountDto(userDto.getUser_id(), a.getAccountKey(), a.getPriKey()));
        }

        userDto.setAccount(accountDto);
        return ResponseEntity.ok()
                .body(userDto);
    }

}
