package com.popov.notification.service.utils.mappers.person;

import com.popov.notification.service.entity.person.Person;
import com.popov.notification.service.entity.person.dto.PersonDto;
import com.popov.notification.service.entity.person.phone.PhoneNumber;
import com.popov.notification.service.utils.mappers.person.qualifires.SetEmailFromEntity;
import com.popov.notification.service.utils.mappers.person.qualifires.ToNormalizedPhone;
import com.popov.notification.service.utils.phone.PhoneFormatting;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    @Mapping(target = "phoneNumber", qualifiedBy = ToNormalizedPhone.class)
    @Mapping(target = "email", qualifiedBy = SetEmailFromEntity.class)
    Person toPerson(PersonDto personDto);

    PersonDto toPersonDto(Person person);

    List<PersonDto> toPersonDtoList(List<Person> personList);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updatePersonFromDto(PersonDto dto, @MappingTarget Person person);


    @SetEmailFromEntity
    static String setEmail(String email) {
        return email;
    }
    @ToNormalizedPhone
    static PhoneNumber toNormalizedPhone(PhoneNumber phoneNumber) {

        phoneNumber.setNationalNumber(PhoneFormatting.getInstance()
                .convertToNormalizedPhoneNumber(phoneNumber.getNationalNumber(), phoneNumber.getCountryCode()));
        phoneNumber.setCarrierCode(PhoneFormatting.getInstance().getCarrierCode(phoneNumber.getNationalNumber(), phoneNumber.getCountryCode()));
        return phoneNumber;
    }
}
