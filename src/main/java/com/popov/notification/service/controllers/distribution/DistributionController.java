package com.popov.notification.service.controllers.distribution;

import com.popov.notification.service.entity.mail.dto.MailDto;
import com.popov.notification.service.service.distribution.DistributionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("dist/")
public class DistributionController {

    @Autowired
    DistributionService distributionService;

    @PostMapping
    public void sendEmail(@RequestBody MailDto mailDto) {
        distributionService.sendMailsToAllEmail(mailDto);
    }

    @PostMapping(params = "carrierCode")
    public void sendEmail(@RequestBody MailDto mailDto, @RequestParam String carrierCode) {
        distributionService.sendFilteredMailsWithCarrierCode(mailDto, carrierCode);
    }
}
