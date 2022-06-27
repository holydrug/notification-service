package com.popov.notification.service.service.distribution.filter;

import com.popov.notification.service.entity.mail.dto.MailDto;

import java.util.List;

public interface DistributionFilterService {
    List<MailDto> getListOfAllMails(MailDto mailDto);
    List<MailDto> getFilteredMailsWithCarrierCode(MailDto mailDto, String carrierCode);
}
