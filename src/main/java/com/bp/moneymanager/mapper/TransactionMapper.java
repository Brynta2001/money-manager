package com.bp.moneymanager.mapper;

import com.bp.moneymanager.dto.TransactionRequestDto;
import com.bp.moneymanager.models.Transaction;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TransactionMapper {
    Transaction toTransaction(TransactionRequestDto transactionRequestDto);
    TransactionRequestDto toTransactionRequestDto(Transaction transaction);
}
