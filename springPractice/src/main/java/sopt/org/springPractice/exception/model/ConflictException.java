package sopt.org.springPractice.exception.model;

import sopt.org.springPractice.exception.Error;

public class ConflictException extends SoptException {
    public ConflictException(Error error, String message) {
        super(error, message);
    }
}
