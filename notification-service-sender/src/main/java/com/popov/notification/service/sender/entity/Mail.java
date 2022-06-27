package com.popov.notification.service.sender.entity;

import lombok.*;

import java.io.Serializable;
import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Mail implements Serializable {



    private String message;
    private String receiver;
    private String subject;

    private Date sentTime;
    private Date editedTime;


}
