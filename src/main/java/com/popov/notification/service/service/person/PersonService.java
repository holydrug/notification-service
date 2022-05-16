package com.popov.notification.service.service.person;

import com.popov.notification.service.dao.person.PersonServiceDao;
import com.popov.notification.service.entity.person.Person;
import com.popov.notification.service.entity.person.dto.PersonDto;
import com.popov.notification.service.error.general.EntityAlreadyExistsException;
import com.popov.notification.service.error.general.EntityNotFoundException;
import com.popov.notification.service.repository.person.repository.PersonRepository;
import com.popov.notification.service.utils.mappers.PersonMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Slf4j


public class PersonService implements PersonServiceDao {

    @Autowired
    private final PersonRepository personRepository;

    @Override
    public Optional<PersonDto> get(Long id) {

        Person person = personRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Person.class, "id", id.toString()));

        log.info("Person successfully found with id: " + id);
        return Optional.of(PersonMapper.INSTANCE.toPersonDto(person));
    }

    @Override
    public List<PersonDto> getAll() {

        return PersonMapper.INSTANCE.toPersonDtoList(personRepository.findAll());
    }

    @Override
    public void save(PersonDto personDto) {

        if (personRepository.findById(personDto.getId()).isPresent()) {
            throw new EntityAlreadyExistsException(Person.class, "id", personDto.getId().toString());
        }

        personRepository.save(PersonMapper.INSTANCE.toPerson(personDto));
        log.info("Person successfully saved with id: " + personDto.getId());
    }

    @Override
    public void update(PersonDto personDto) {

        Person person = personRepository.findById(personDto.getId())
                .orElseThrow(() -> new EntityNotFoundException(Person.class, "id", personDto.getId().toString()));
        PersonMapper.INSTANCE.updatePersonFromDto(personDto, person);


        personRepository.save(person);
        log.info("Person successfully updated with id: " + personDto.getId());
    }

    @Override
    public void delete(Long id) {

        Person person = personRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Person.class, "id", id.toString()));

        personRepository.deleteById(PersonMapper.INSTANCE.toPersonDto(person).getId());
        log.info("Person successfully deleted with id: " + id);
    }
}
