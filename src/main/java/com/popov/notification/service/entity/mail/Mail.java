package com.popov.notification.service.entity.mail;

import com.popov.notification.service.entity.person.Person;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;



@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Mail implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String message;
    private String receiver;
    private String subject;

    private Date sentTime;
    private Date editedTime;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;


}
