package sopt.org.springPractice.exception.model;

import sopt.org.springPractice.exception.Error;

public class BadRequestException extends SoptException {
    public BadRequestException(Error error, String message) {
        super(error, message);
    }
}
