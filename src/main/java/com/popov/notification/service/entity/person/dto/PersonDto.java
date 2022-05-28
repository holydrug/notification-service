package com.popov.notification.service.entity.person.dto;

import com.popov.notification.service.entity.person.phone.PhoneNumber;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class PersonDto {

    @NonNull
    private Long id;
    private String name;
    private PhoneNumber phoneNumber;

    private String email;

    @Override
    public String toString() {
        return "\nPersonDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", email='" + email + '\'' +
                '}';
    }
}
