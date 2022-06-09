package com.popov.notification.service.service.mail.sender;

import com.popov.notification.service.entity.mail.Mail;
import com.popov.notification.service.entity.mail.dto.MailDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailSenderService {

    @Autowired
    JavaMailSender mailSender;

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
