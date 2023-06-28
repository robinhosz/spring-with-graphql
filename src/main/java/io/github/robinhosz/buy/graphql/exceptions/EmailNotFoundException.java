package io.github.robinhosz.buy.graphql.exceptions;

public class EmailNotFoundException extends RuntimeException {

    public EmailNotFoundException(String message) {
        super(message);
    }
}
