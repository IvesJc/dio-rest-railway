package me.dio.exception;

import java.util.NoSuchElementException;

public class UserNotFoundException extends NoSuchElementException {


    public UserNotFoundException(){
        super("User not found");
    }
    public UserNotFoundException(String message) {
        super(message);
    }
}
