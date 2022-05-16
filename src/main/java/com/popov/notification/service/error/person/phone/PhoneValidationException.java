package com.popov.notification.service.error.person.phone;

public class PhoneValidationException extends RuntimeException {
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
