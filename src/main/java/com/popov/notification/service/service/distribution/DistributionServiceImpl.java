package com.popov.notification.service.service.distribution;

import com.popov.notification.service.entity.mail.dto.MailDto;
import com.popov.notification.service.service.distribution.filter.DistributionFilterServiceImpl;
import com.popov.notification.service.service.mail.MailServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DistributionServiceImpl implements DistributionService {

    private final MailServiceImpl mailService;
    private final DistributionFilterServiceImpl distrFilterService;

    public void sendMailsToAllEmail(MailDto mailDto) {
        distrFilterService.getListOfAllMails(mailDto).forEach(mailService::send);
    }

    public void sendFilteredMailsWithCarrierCode(MailDto mailDto, String carrierCode) {
        distrFilterService.getFilteredMailsWithCarrierCode(mailDto, carrierCode).forEach(mailService::send);
    }
}
