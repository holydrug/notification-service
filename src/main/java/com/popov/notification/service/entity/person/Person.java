package com.popov.notification.service.entity.person;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.popov.notification.service.entity.person.phone.PhoneNumber;
import com.popov.notification.service.entity.person.phone.validator.annotation.Phone;
import lombok.*;

import javax.persistence.*;
import javax.validation.Valid;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @NonNull
    private String name;

    @Phone
    @Valid
    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "phone_number_id", referencedColumnName = "id")
    @NonNull
    private PhoneNumber phoneNumber;

    /*
     */

}
