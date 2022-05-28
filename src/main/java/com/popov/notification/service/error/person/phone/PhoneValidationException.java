package com.popov.notification.service.error.person.phone;

import com.popov.notification.service.error.general.common.NotificationServiceException;

public class PhoneValidationException extends NotificationServiceException {
    public PhoneValidationException() {
        super();
    }

    public PhoneValidationException(String message, Throwable cause) {
        super(message, cause);
    }

    public PhoneValidationException(String message) {
        super(message);
    }

    public PhoneValidationException(Throwable cause) {
        super(cause);
    }
}
