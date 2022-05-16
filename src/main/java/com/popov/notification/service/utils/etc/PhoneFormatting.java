package com.popov.notification.service.utils.etc;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import org.springframework.stereotype.Component;


@Component
public class PhoneFormatting {


    private static PhoneFormatting instance;

    public static PhoneFormatting getInstance() {
        if (instance == null) {
            instance = new PhoneFormatting();
        }
        return instance;
    }

    public String convertToNormalizedPhoneNumber(String nationalNumber, String countryCode) {

        try {
            PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();
            Phonenumber.PhoneNumber phoneNumberGoogle = phoneNumberUtil.parse(nationalNumber, countryCode);

            return Long.toString(phoneNumberGoogle.getCountryCode()) + (phoneNumberGoogle.getNationalNumber());
        } catch (NumberParseException e) {
            return null;
        }
    }

}
