package com.popov.notification.service.sender.properties.rabbitmq;

import com.popov.notification.service.sender.properties.rabbitmq.etc.Exchanges;
import com.popov.notification.service.sender.properties.rabbitmq.etc.Queues;
import com.popov.notification.service.sender.properties.rabbitmq.etc.RoutingKeys;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RabbitMq {
    private int port;
    private String host;
    private String username;
    private String password;

    private Exchanges exchanges;
    private Queues queues;
    private RoutingKeys routingKeys;
}
