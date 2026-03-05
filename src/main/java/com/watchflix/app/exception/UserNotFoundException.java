package com.watchflix.app.exception;

import java.util.UUID;

public class UserNotFoundException extends RuntimeException{



    public UserNotFoundException()
    {
        super("The user cannot be found");



    }

}
