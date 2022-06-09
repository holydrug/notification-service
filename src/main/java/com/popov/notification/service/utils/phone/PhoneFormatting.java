package com.popov.notification.service.utils.phone;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberToCarrierMapper;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import org.springframework.stereotype.Component;

import java.util.Locale;


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

    public String getCarrierCode(String nationalNumber, String countryCode) {


        try {
            PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();
            Phonenumber.PhoneNumber phoneNumberGoogle = phoneNumberUtil.parse(nationalNumber, countryCode);

            if(PhoneNumberToCarrierMapper.getInstance().getNameForNumber(phoneNumberGoogle, Locale.ENGLISH) == "")
                return "FAILED TO DETERMINATE";
            return PhoneNumberToCarrierMapper.getInstance().getNameForNumber(phoneNumberGoogle, Locale.ENGLISH);
        } catch (NumberParseException e) {
            return null;
        }
    }
}
