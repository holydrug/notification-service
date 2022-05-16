package com.popov.notification.service.repository.person.repository.phone;

import com.popov.notification.service.entity.person.phone.PhoneNumber;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneNumberRepository extends JpaRepository<PhoneNumber, Long> {
}
