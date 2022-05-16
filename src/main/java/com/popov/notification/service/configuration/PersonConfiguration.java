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

        return args -> personRepository.save(new Person("AMOGUS", new PhoneNumber("RU", "+7977a5798544")));
    }
}
