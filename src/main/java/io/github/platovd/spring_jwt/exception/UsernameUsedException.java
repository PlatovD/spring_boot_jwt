package io.github.platovd.spring_jwt.exception;

public class UsernameUsedException extends RuntimeException {
    public UsernameUsedException(String message) {
        super(message);
    }
}
