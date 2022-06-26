package com.popov.notification.service.service.distribution;

import com.popov.notification.service.entity.mail.dto.MailDto;

public interface DistributionService {
    void sendMailsToAllEmail(MailDto mailDto);
    void sendFilteredMailsWithCarrierCode(MailDto mailDto, String carrierCode);
}
