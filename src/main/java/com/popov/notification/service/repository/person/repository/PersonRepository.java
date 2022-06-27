package com.popov.notification.service.repository.person.repository;

import com.popov.notification.service.entity.person.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
