package com.popov.notification.service.properties.rabbitmq;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RabbitMq {
    private String host;
    private String username;
    private String password;
    private int port;
}
