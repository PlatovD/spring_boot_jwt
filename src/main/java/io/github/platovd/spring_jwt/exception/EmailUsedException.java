package io.github.platovd.spring_jwt.exception;

public class EmailUsedException extends RuntimeException {
    public EmailUsedException(String message) {
        super(message);
    }
}
