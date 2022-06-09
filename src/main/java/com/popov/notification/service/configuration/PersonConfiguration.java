package com.popov.notification.service.configuration;

import com.popov.notification.service.entity.person.Person;
import com.popov.notification.service.entity.person.phone.PhoneNumber;
import com.popov.notification.service.repository.person.repository.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersonConfiguration {

    @Bean
    public CommandLineRunner saveSomeClients(PersonRepository personRepository) {
        return args -> {
            personRepository.save(new Person("SIMEN", new PhoneNumber("RU", "79262675371"), "notifiedservice@gmail.com"));
            personRepository.save(new Person("AMOGUS", new PhoneNumber("RU", "79775798542"), "notifiedservice@gmail.com"));
            personRepository.save(new Person("SEBILLA", new PhoneNumber("RU", "79685243033"), "notifiedservice@gmail.com"));
            personRepository.save(new Person("SELICIA", new PhoneNumber("RU", "79117762654"), "notifiedservice@gmail.com"));
            personRepository.save(new Person("AMIRO", new PhoneNumber("RU", "79670503235"), "notifiedservice@gmail.com"));
        };
    }
}
