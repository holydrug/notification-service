package com.popov.notification.service.service.mail;

import com.popov.notification.service.entity.mail.Mail;
import com.popov.notification.service.entity.mail.dto.MailDto;
import com.popov.notification.service.properties.YAMLProperties;
import com.popov.notification.service.repository.mail.repository.MailRepository;
import com.popov.notification.service.utils.mappers.mail.MailMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class MailServiceImpl implements MailService {

    private final YAMLProperties properties;
    private final MailRepository mailRepository;
    private final RabbitTemplate rabbitTemplate;


    public void send(MailDto mailDto) {

        Mail mail = MailMapper.INSTANCE.toMail(mailDto);
        rabbitTemplate.convertAndSend(
                properties.getRabbitMq().getExchanges().getInternal(),
                properties.getRabbitMq().getRoutingKeys().getNotification(),
                mail);
        log.info("MAIL SEND?");

        mailRepository.save(mail);
    }

    public List<MailDto> getAll() {

        return MailMapper.INSTANCE.toMailDtoList(mailRepository.findAll());
    }

    public void update(MailDto mailDto) {

        Mail mail = mailRepository.findById(mailDto.getId())
                .orElseThrow(NullPointerException::new);

        mailDto.setSentTime(mail.getSentTime());
        MailMapper.INSTANCE.updateMailFromDto(mailDto, mail);
        mailDto.setEditedTime(mail.getEditedTime());

        rabbitTemplate.convertAndSend(
                properties.getRabbitMq().getExchanges().getInternal(),
                properties.getRabbitMq().getRoutingKeys().getNotification(),
                mail);
        log.info("MAIL SEND?");

        mailRepository.save(mail);
    }
}
