package com.popov.notification.service.entity.person;

import com.popov.notification.service.entity.person.phone.PhoneNumber;
import com.popov.notification.service.entity.person.phone.validator.annotation.Phone;
import lombok.*;

import javax.persistence.*;
import javax.validation.Valid;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
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
    @OneToOne(cascade = CascadeType.ALL)
    @NonNull
    private PhoneNumber phoneNumber;



    /*
     */

}
