package com.popov.notification.service.error.general.common;

public class NotificationServiceException extends RuntimeException {
    public NotificationServiceException() {
        super();
    }

    public NotificationServiceException(String message) {
        super(message);
    }

    public NotificationServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotificationServiceException(Throwable cause) {
        super(cause);
    }

    public NotificationServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
