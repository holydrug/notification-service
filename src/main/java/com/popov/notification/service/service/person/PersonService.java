package com.popov.notification.service.service.person;

import com.popov.notification.service.entity.person.dto.PersonDto;

import java.util.List;
import java.util.Optional;

public interface PersonService {
    Optional<PersonDto> get(Long id);
    List<PersonDto> getAll();
    void save(PersonDto personDto);
    void update(PersonDto personDto);
    void delete(Long id);

}
