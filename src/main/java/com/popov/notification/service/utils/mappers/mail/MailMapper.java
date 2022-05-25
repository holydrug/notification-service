package com.popov.notification.service.utils.mappers.mail;

import com.popov.notification.service.entity.mail.Mail;
import com.popov.notification.service.entity.mail.dto.MailDto;
import com.popov.notification.service.entity.person.Person;
import com.popov.notification.service.entity.person.dto.PersonDto;
import com.popov.notification.service.utils.mappers.mail.qualifires.ToEditedTime;
import com.popov.notification.service.utils.mappers.mail.qualifires.ToUpdatedTime;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@Mapper(componentModel = "spring")
public interface MailMapper {

    MailMapper INSTANCE = Mappers.getMapper(MailMapper.class);

    MailDto toMailDto(Mail mail);

    @Mapping(target = "sentTime", qualifiedBy = ToUpdatedTime.class)
    public Mail toMail(MailDto mailDto);

    List<MailDto> toMailDtoList(List<Mail> mailList);


    @Mapping(target = "editedTime", qualifiedBy = ToUpdatedTime.class)
    void updateMailFromDto(MailDto dto, @MappingTarget Mail mail);

    @ToUpdatedTime
    public static Date toUpdatedTime(Date time) {
        return Date.from(Instant.now());
    }

}
