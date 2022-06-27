package com.popov.notification.service.utils.mappers.phone;

import com.popov.notification.service.entity.person.phone.PhoneNumber;
import com.popov.notification.service.entity.person.phone.dto.PhoneNumberDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PhoneMapper {

    PhoneMapper INSTANCE = Mappers.getMapper(PhoneMapper.class);

    PhoneNumberDto toPhoneNumberDto(PhoneNumber phoneNumber);
    PhoneNumber toPhoneNumber(PhoneNumberDto phoneNumberDto);

    List<PhoneNumberDto> toPhoneNumberDtoList(List<PhoneNumber> phoneNumberList);
}
