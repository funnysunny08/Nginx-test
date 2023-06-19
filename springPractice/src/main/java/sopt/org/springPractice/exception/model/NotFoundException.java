package sopt.org.springPractice.exception.model;

import sopt.org.springPractice.exception.Error;

public class NotFoundException extends SoptException {
    public NotFoundException(Error error, String message) {
        super(error, message);
    }
}
