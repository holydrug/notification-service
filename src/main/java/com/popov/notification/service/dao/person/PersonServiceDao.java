package com.popov.notification.service.dao.person;

import com.popov.notification.service.dao.Dao;
import com.popov.notification.service.entity.person.dto.PersonDto;

import java.util.List;
import java.util.Optional;

public interface PersonServiceDao extends Dao<PersonDto> {


    public List<PersonDto> getAll();
    public Optional<PersonDto> get(Long id);
    public void save(PersonDto personDto);
    public void delete(Long id);
}
