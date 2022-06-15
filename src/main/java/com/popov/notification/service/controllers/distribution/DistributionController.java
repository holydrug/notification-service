package com.popov.notification.service.controllers.distribution;

import com.popov.notification.service.entity.mail.dto.MailDto;
import com.popov.notification.service.service.distribution.DistributionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("dist/")
public class DistributionController {


    private final DistributionService distributionService;

    @PostMapping
    public void sendEmail(@RequestBody MailDto mailDto) {
        distributionService.sendMailsToAllEmail(mailDto);
    }

    @PostMapping(params = "carrierCode")
    public void sendEmail(@RequestBody MailDto mailDto, @RequestParam String carrierCode) {
        distributionService.sendFilteredMailsWithCarrierCode(mailDto, carrierCode);
    }
}
