package com.pragma.messenger.application.mapper;

import com.pragma.messenger.application.dto.CustomerMessageDto;
import com.pragma.messenger.domain.model.CustomerMessage;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CustomerMessageDtoMapper {
    CustomerMessageDto toDto(CustomerMessage customerMessage);
    CustomerMessage toDomain(CustomerMessageDto customerMessageDto);
}
