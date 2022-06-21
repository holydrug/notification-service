package com.popov.notification.service.sender;

import com.popov.notification.service.sender.entity.Mail;
import com.popov.notification.service.sender.service.MailSenderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@EnableRabbit
@Component
@Slf4j
@RequiredArgsConstructor
public class Consumer {

    private final MailSenderService mailSenderService;

    @RabbitListener(queues = "notification.queue")
    private void receive(Mail mail){
        mailSenderService.sendMail(mail);
        log.info(mail.toString());
    }
}
