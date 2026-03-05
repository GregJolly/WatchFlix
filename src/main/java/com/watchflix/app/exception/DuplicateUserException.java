package com.watchflix.app.exception;

public class DuplicateUserException extends RuntimeException{

    private final String username;

    public DuplicateUserException(String username)
    {
        super(String.format("%s already exists in the app", username));
        this.username=username;
    }
}
