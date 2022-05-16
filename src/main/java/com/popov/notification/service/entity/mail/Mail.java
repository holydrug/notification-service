package com.popov.notification.service.entity.mail;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Mail {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "text")
    private String text;



}
