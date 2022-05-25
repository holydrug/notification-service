package com.popov.notification.service.utils.mappers.person;

import com.popov.notification.service.entity.person.Person;
import com.popov.notification.service.entity.person.dto.PersonDto;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    Person toPerson(PersonDto personDto); /* {

        PhoneNumber phoneNumber = personDto.getPhoneNumber();

        phoneNumber.setNationalNumber(PhoneFormatting.getInstance()
                .convertToNormalizedPhoneNumber(phoneNumber.getNationalNumber(), phoneNumber.getCountryCode()));
        phoneNumber.setCarrierCode(PhoneFormatting.getInstance().getCarrierCode(phoneNumber.getNationalNumber()));

        Person person = new Person();
        person.setPhoneNumber(phoneNumber);
        person.setName(personDto.getName());
        person.setId(personDto.getId());


        return person;
    }*/

    PersonDto toPersonDto(Person person);

    List<PersonDto> toPersonDtoList(List<Person> personList);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updatePersonFromDto(PersonDto dto, @MappingTarget Person person);
}
