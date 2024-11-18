package com.bp.moneymanager.mapper;

import com.bp.moneymanager.dto.ClientRequestDto;
import com.bp.moneymanager.models.Client;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    Client toClient(ClientRequestDto clientRequestDto);
    ClientRequestDto toClientRequestDto(Client client);
}
