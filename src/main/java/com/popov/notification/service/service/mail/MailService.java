package com.popov.notification.service.service.mail;

import com.popov.notification.service.entity.mail.Mail;
import com.popov.notification.service.entity.mail.dto.MailDto;
import com.popov.notification.service.repository.mail.repository.MailRepository;
import com.popov.notification.service.service.mail.sender.MailSenderService;
import com.popov.notification.service.utils.mappers.mail.MailMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MailService {

    @Autowired
    private final MailSenderService mailSenderService;

    @Autowired
    private final MailRepository mailRepository;


    public void send(MailDto mailDto) {

        Mail mail = MailMapper.INSTANCE.toMail(mailDto);

        mailSenderService.sendMail(mailDto, mail);
        mailRepository.save(mail);
    }

    public List<MailDto> getAll() {

        return MailMapper.INSTANCE.toMailDtoList(mailRepository.findAll());
    }

    public void update(MailDto mailDto) {

        Mail mail = mailRepository.findById(mailDto.getId())
                        .orElseThrow(() -> new NullPointerException());

        mailDto.setSentTime(mail.getSentTime());
        MailMapper.INSTANCE.updateMailFromDto(mailDto, mail);
        mailDto.setEditedTime(mail.getEditedTime());

        mailSenderService.sendMail(mailDto, mail);
        mailRepository.save(mail);
    }
}
