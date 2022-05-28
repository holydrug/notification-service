package com.popov.notification.service.entity.person.phone.dto;

import com.popov.notification.service.entity.person.dto.PersonDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhoneNumberDto {

    private Long id;

    private PersonDto personDto;

    private String countryCode;
    private String carrierCode;

    private String nationalNumber;

}
