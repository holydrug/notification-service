package com.popov.notification.service.broker;

import com.popov.notification.service.properties.YAMLProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.yaml.snakeyaml.Yaml;

@RequiredArgsConstructor
@Configuration
public class RabbitMqConfiguration {


    private final YAMLProperties properties;

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(properties.getRabbitMq().getExchanges().getInternal());
    }

    @Bean
    public Queue defaultParsingQueue() {
        return new Queue(properties.getRabbitMq().getQueues().getNotification());
    }

    @Bean
    public Binding queueToExchangeBinding() {
        return BindingBuilder
                .bind(defaultParsingQueue())
                .to(topicExchange())
                .with(properties.getRabbitMq().getRoutingKeys().getNotification());
    }
}

