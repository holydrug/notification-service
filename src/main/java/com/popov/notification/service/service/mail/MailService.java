package com.popov.notification.service.service.mail;

import com.popov.notification.service.entity.mail.dto.MailDto;

import java.util.List;

public interface MailService {
    void send(MailDto mailDto);
    List<MailDto> getAll();
    void update(MailDto mailDto);
}
