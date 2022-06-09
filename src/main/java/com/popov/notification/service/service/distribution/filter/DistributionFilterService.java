package com.popov.notification.service.service.distribution.filter;

import com.popov.notification.service.entity.mail.dto.MailDto;
import com.popov.notification.service.entity.person.Person;
import com.popov.notification.service.entity.person.phone.PhoneNumber;
import com.popov.notification.service.error.general.entity.EntityNotFoundException;
import com.popov.notification.service.repository.person.repository.PersonRepository;
import com.popov.notification.service.repository.person.repository.phone.PhoneNumberRepository;
import com.popov.notification.service.utils.mappers.person.PersonMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class DistributionFilterService {

    @Autowired
    PersonRepository personRepository;
    @Autowired
    PhoneNumberRepository phoneNumberRepository;

    private MailDto setReceiverToMailDtoFromPDto(Person person) {
        if(person == null)
            new EntityNotFoundException(Person.class, "", "");

        MailDto mailDto = new MailDto();
        mailDto.setReceiver(person.getEmail());
        mailDto.setPersonDto(PersonMapper.INSTANCE.toPersonDto(person));

        log.info("MailDto successfully setup with receiver: " + person.getEmail());
        log.info("PersonDto successfully setup with params: " + mailDto.getPersonDto().toString());
        return mailDto;
    }

    private List<MailDto> generateEmptyMailDto(List<Person> personList) {
        return personList.stream()
                .map(this::setReceiverToMailDtoFromPDto)
                .collect(Collectors.toList());
    }

    public List<MailDto> getListOfAllMails(MailDto mailDto) {
        return generateEmptyMailDto(personRepository.findAll()).stream()
                .peek(x -> {
                    x.setMessage(mailDto.getMessage());
                    x.setSubject(mailDto.getSubject());
                })
                .collect(Collectors.toList());

    }

    public List<MailDto> getFilteredMailsWithCarrierCode(MailDto mailDto, String carrierCode) {
        List<Person> filteredPersonList = phoneNumberRepository.getFilteredPhonesWithCarrierCode(carrierCode).stream()
                .map(PhoneNumber::getPerson)
                .collect(Collectors.toList());
        log.info("PhoneNumberRepo successfully mapped to Person list with size: " + filteredPersonList.size());

        return generateEmptyMailDto(filteredPersonList).stream()
                        .peek(x -> {
                            x.setMessage(mailDto.getMessage());
                            x.setSubject(mailDto.getSubject());
                        })
                        .collect(Collectors.toList());

    }


}
