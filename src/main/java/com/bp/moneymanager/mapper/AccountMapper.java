package com.bp.moneymanager.mapper;

import com.bp.moneymanager.dto.AccountRequestDto;
import com.bp.moneymanager.models.Account;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountMapper {
    Account toAccount(AccountRequestDto accountRequestDto);
    AccountRequestDto toAccountRequestDto(Account account);
}
