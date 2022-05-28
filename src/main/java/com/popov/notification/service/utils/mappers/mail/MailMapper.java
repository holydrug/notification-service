package com.popov.notification.service.utils.mappers.mail;

import com.popov.notification.service.entity.mail.Mail;
import com.popov.notification.service.entity.mail.dto.MailDto;
import com.popov.notification.service.entity.person.Person;
import com.popov.notification.service.entity.person.dto.PersonDto;
import com.popov.notification.service.utils.mappers.mail.qualifires.PersonMapperLink;
import com.popov.notification.service.utils.mappers.mail.qualifires.ToUpdatedTime;
import com.popov.notification.service.utils.mappers.person.PersonMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@Mapper(componentModel = "spring")
public interface MailMapper {

    MailMapper INSTANCE = Mappers.getMapper(MailMapper.class);

    MailDto toMailDto(Mail mail);

    @Mapping(source = "personDto", target = "person", qualifiedBy = PersonMapperLink.class)
    @Mapping(target = "sentTime", qualifiedBy = ToUpdatedTime.class)
    public Mail toMail(MailDto mailDto);

    List<MailDto> toMailDtoList(List<Mail> mailList);


    @Mapping(target = "editedTime", qualifiedBy = ToUpdatedTime.class)
    void updateMailFromDto(MailDto dto, @MappingTarget Mail mail);

    @ToUpdatedTime
    public static Date toUpdatedTime(Date time) {
        return Date.from(Instant.now());
    }

    @PersonMapperLink
    public static Person toPerson(PersonDto personDto) {
        return PersonMapper.INSTANCE.toPerson(personDto);
    }

}
