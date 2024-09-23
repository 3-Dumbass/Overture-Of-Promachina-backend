package com.oops.OvertureOfPromachina.application.service.business.Account;

import com.oops.OvertureOfPromachina.application.controller.account.dto.AccountDto;
import com.oops.OvertureOfPromachina.application.controller.user.dto.UserDto;
import com.oops.OvertureOfPromachina.application.entity.account.Account;
import com.oops.OvertureOfPromachina.application.entity.user.User;
import com.oops.OvertureOfPromachina.application.repository.Account.AccountRepository;
import com.oops.OvertureOfPromachina.application.service.business.User.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    private final UserService userService;

    public Boolean saveAccount(AccountDto accountDto) {

        User user_data = userService.selectUserData(accountDto.getUser_id());
        Account account_data = new Account(user_data, accountDto.getAccountKey(), accountDto.getPriKey());

        Long save_check = accountRepository.save(account_data);
        return save_check != null;
    }

    public List<Account> getAccounts(UserDto userDto) {
        return accountRepository.findAccount(userDto.getId());
    }


}
