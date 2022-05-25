package com.popov.notification.service.controllers.mail.controller;

import com.popov.notification.service.entity.mail.dto.MailDto;
import com.popov.notification.service.entity.person.dto.PersonDto;
import com.popov.notification.service.service.mail.MailService;
import com.popov.notification.service.service.mail.sender.MailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("email/")
public class MailController {

    @Autowired
    private MailService mailService;

    @GetMapping
    public ResponseEntity receiveAllMails(){

        mailService.getAll();
        return ResponseEntity.ok("SUCCESS");
    }

    @PostMapping
    public ResponseEntity sendEmail(@RequestBody MailDto mailDto){

        mailService.send(mailDto);
        return ResponseEntity.ok("SUCCESS");
    }

    @PatchMapping(path = "{id}")
    public void updatePersonById(@RequestBody MailDto mailDto) {
        mailService.update(mailDto);
        ResponseEntity.ok("SUCCESS");
    }



}
