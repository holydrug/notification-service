package com.popov.notification.service.entity.person.phone.validator.annotation;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.popov.notification.service.entity.person.phone.PhoneNumber;
import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Slf4j
public class PhoneNumberValidator implements ConstraintValidator<Phone, PhoneNumber> {

    @Override
    public void initialize(Phone constraintAnnotation) {
    }

    @Override
    public boolean isValid(PhoneNumber phoneNumber, ConstraintValidatorContext context) {

        if (phoneNumber.getCountryCode() == null || phoneNumber.getNationalNumber() == null) {
            return false;
        }
        try {
            PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();
            phoneNumberUtil.parse(phoneNumber.getNationalNumber(), phoneNumber.getCountryCode());
            return phoneNumberUtil.isValidNumber(phoneNumberUtil.parse(phoneNumber.getNationalNumber(), phoneNumber.getCountryCode()));
        } catch (NumberParseException e) {
            log.error("Unable phone validation", e);
            return false;
        }
    }
}