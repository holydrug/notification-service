package com.popov.notification.service.entity.person.dto;

import com.popov.notification.service.entity.person.phone.PhoneNumber;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public class PersonDto {

    @NonNull
    private Long id;
    private String name;
    private PhoneNumber phoneNumber;


}
