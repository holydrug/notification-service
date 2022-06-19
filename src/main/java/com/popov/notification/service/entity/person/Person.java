package com.popov.notification.service.entity.person;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.popov.notification.service.entity.person.phone.PhoneNumber;
import com.popov.notification.service.entity.person.phone.validator.annotation.Phone;
import lombok.*;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import java.io.Serializable;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "persons")
public class Person implements Serializable {

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

    @Email
    private String email;

    public Person(@NonNull String name, @NonNull PhoneNumber phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public Person(@NonNull String name, @NonNull PhoneNumber phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
}
