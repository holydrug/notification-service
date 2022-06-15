package com.popov.notification.service.service.distribution;

import com.popov.notification.service.entity.mail.dto.MailDto;
import com.popov.notification.service.service.distribution.filter.DistributionFilterService;
import com.popov.notification.service.service.mail.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DistributionService {

    private final MailService mailService;
    private final DistributionFilterService distrFilterService;

    public void sendMailsToAllEmail(MailDto mailDto) {
        distrFilterService.getListOfAllMails(mailDto).forEach(mailService::send);
    }

    public void sendFilteredMailsWithCarrierCode(MailDto mailDto, String carrierCode) {
        distrFilterService.getFilteredMailsWithCarrierCode(mailDto, carrierCode).forEach(mailService::send);
    }
}
