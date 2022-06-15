package com.popov.notification.service.service.mail.sender;

import com.popov.notification.service.entity.mail.Mail;
import com.popov.notification.service.entity.mail.dto.MailDto;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailSenderService {

    private final JavaMailSender mailSender;

    public void sendMail(MailDto mailDto, Mail mail) {



        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("notifiedservice@gmail.com");
        simpleMailMessage.setTo(mail.getReceiver());
        simpleMailMessage.setSubject(mail.getSubject());
        simpleMailMessage.setText(mail.getSubject() + "\n" + mail.getMessage() + "\n\n" + "sent date: \n" + mail.getSentTime() + "\n" + "edited date: \n" + mail.getEditedTime());
        simpleMailMessage.setSentDate(mail.getSentTime());

        mailSender.send(simpleMailMessage);
    }

}
