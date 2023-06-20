package sopt.org.springPractice.exception.model;

import sopt.org.springPractice.exception.Error;

public class UnauthorizedException extends SoptException{
    public UnauthorizedException(Error error, String message) {
        super(error, message);
    }
}
