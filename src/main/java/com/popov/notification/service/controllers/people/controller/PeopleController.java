package com.popov.notification.service.controllers.people.controller;

import com.popov.notification.service.entity.person.dto.PersonDto;
import com.popov.notification.service.service.person.PersonServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("person-management/persons/") // ресурс - персон
public class PeopleController {

    private final PersonServiceImpl personService;

    @GetMapping()
    public List<PersonDto> getAllPeople() {
        return personService.getAll();
    }

    @GetMapping(path = "{id}")
    public Optional<PersonDto> getPerson(@PathVariable Long id) {
        return personService.get(id);
    }

    @PostMapping()
    public void savePerson(@RequestBody PersonDto personDto) {
        personService.save(personDto);
    }

    @PatchMapping(path = "{id}")
    public void updatePersonById(@RequestBody PersonDto personDto) {
        personService.update(personDto);
    }

    @DeleteMapping(path = "{id}")
    public void deletePersonById(@PathVariable Long id) {
        personService.delete(id);
    }


}
