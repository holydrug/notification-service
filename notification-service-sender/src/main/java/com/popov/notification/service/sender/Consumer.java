package com.popov.notification.service.sender;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.popov.notification.service.sender.entity.Mail;
import com.popov.notification.service.sender.service.MailSenderService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.utils.SerializationUtils;
import org.springframework.stereotype.Component;

@EnableRabbit
@Component
@Slf4j
@RequiredArgsConstructor
public class Consumer {

    private final MailSenderService mailSenderService;
    private final ObjectMapper objectMapper;

    @SneakyThrows
    @RabbitListener(queues = "${rabbitmq.queues.notification}")
    private void receive(Message message){

        Mail mail = objectMapper.readValue(message.getBody(), Mail.class);
        mailSenderService.sendMail(mail);
    }
}
