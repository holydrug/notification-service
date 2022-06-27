package com.popov.notification.service.entity.mail;

import com.fasterxml.jackson.annotation.JsonProperty;
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

    @JsonProperty
    private String message;
    @JsonProperty
    private String receiver;
    @JsonProperty
    private String subject;

    @JsonProperty
    private Date sentTime;
    @JsonProperty
    private Date editedTime;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;


}
