package com.popov.notification.service.error.person;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PersonNullPointerException extends RuntimeException {

    public PersonNullPointerException() {
        super();
    }

    public PersonNullPointerException(String message, Throwable cause) {
        super(message, cause);
    }

    public PersonNullPointerException(String message) {
        super(message);
    }

    public PersonNullPointerException(Throwable cause) {
        super(cause);
    }
}
