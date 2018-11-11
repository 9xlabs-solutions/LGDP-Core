package com.ninexlabs.lgdp.commons;

/**
 * by: Pasan Buddhika Weerathunga
 * Email: me@pasanlive.com
 */

public class LGDPException extends RuntimeException {
    private ExceptionType exceptionType;

    public LGDPException(ExceptionType exceptionType, String message) {
        super(message);
        this.exceptionType = exceptionType;
    }

    public LGDPException(ExceptionType exceptionType, String message, Throwable cause) {
        super(message, cause);
        this.exceptionType = exceptionType;
    }

    public ExceptionType getExceptionType() {
        return exceptionType;
    }

    public enum ExceptionType {

        INVALID_DATA_EXCEPTION,

        ALREADY_EXIST_EXCEPTION,

        NOT_AUTHORIZED_EXCEPTION,

        WRONG_VERIFICATION_CODE,

        ACCOUNT_NOT_VERIFIED,

        ACCOUNT_NOT_EXISTS,

        ACCOUNT_ALREADY_VERIFIED,

        RESOURCE_DOES_NOT_EXISTS
    }
}
