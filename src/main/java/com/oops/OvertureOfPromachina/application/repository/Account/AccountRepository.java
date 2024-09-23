package com.oops.OvertureOfPromachina.application.repository.Account;

import com.oops.OvertureOfPromachina.application.controller.user.dto.UserDto;
import com.oops.OvertureOfPromachina.application.entity.account.Account;

import java.util.List;

public interface AccountRepository {

    Long save(Account account);
    List<Account> findAccount(long user_id);
}
