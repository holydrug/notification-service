package com.popov.notification.service.properties;

import com.popov.notification.service.properties.rabbitmq.RabbitMq;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@RequiredArgsConstructor
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties
public class YAMLProperties {

    private RabbitMq rabbitMq;
}
