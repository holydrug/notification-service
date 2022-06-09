package com.popov.notification.service.entity.person.phone;

import com.popov.notification.service.entity.person.Person;
import com.popov.notification.service.utils.phone.PhoneFormatting;
import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "phones")
public class PhoneNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @OneToOne(mappedBy = "phoneNumber")
    private Person person;

    @Column(name = "country_code")
    private String countryCode;

    @Column(name = "carrier_code")
    private String carrierCode;

    @Column(name = "number", unique = true)
    private String nationalNumber;



    public PhoneNumber(String countryCode, String nationalNumber) {
        this.countryCode = countryCode;
        this.nationalNumber = PhoneFormatting.getInstance().convertToNormalizedPhoneNumber(nationalNumber, countryCode);
        this.carrierCode = PhoneFormatting.getInstance().getCarrierCode(nationalNumber, countryCode);
    }

    @Override
    public String toString() {
        return "\nPhoneNumber{" +
                "id=" + id +
                ", person=" + person +
                ", countryCode='" + countryCode + '\'' +
                ", carrierCode='" + carrierCode + '\'' +
                ", nationalNumber='" + nationalNumber + '\'' +
                '}';
    }
}
