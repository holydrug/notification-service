package com.popov.notification.service.entity.person.phone;

import com.popov.notification.service.utils.etc.PhoneFormatting;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

import javax.persistence.*;


@Data
@ToString
@Entity
@NoArgsConstructor
@Table(name = "phones")
public class PhoneNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;


    @Column(name = "country_code")
    private String countryCode;


    @Column(name = "number", unique = true)
    private String nationalNumber;

    public PhoneNumber(@NonNull String countryCode, String nationalNumber) {
        this.countryCode = countryCode;
        this.nationalNumber = (PhoneFormatting.getInstance().convertToNormalizedPhoneNumber(nationalNumber, countryCode));
    }

}
