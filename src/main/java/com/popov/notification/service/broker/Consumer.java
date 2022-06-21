package com.popov.notification.service.broker;

import com.popov.notification.service.entity.mail.Mail;
import com.popov.notification.service.service.mail.sender.MailSenderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@EnableRabbit
@RequiredArgsConstructor
public class Consumer {

    private final MailSenderService mailSenderService;

    @RabbitListener(queues = "notification.queue")
    private void receive(Mail mail){
        mailSenderService.sendMail(mail);
        log.info(mail.toString());
    }

}