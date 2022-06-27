package com.popov.notification.service.entity.mail.dto;

import com.popov.notification.service.entity.person.dto.PersonDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Date;

@Data
@NoArgsConstructor
public class MailDto {


    @NonNull
    private Long id;
    private String message;
    private String receiver;
    private String subject;

    private Date sentTime;
    private Date editedTime;

    private PersonDto personDto;
}
