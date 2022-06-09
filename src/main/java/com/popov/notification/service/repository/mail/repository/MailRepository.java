package com.popov.notification.service.repository.mail.repository;

import com.popov.notification.service.entity.mail.Mail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MailRepository extends JpaRepository<Mail, Long> {
}
