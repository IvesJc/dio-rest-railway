package me.dio.exception;

public class CreateDuplicateUserException extends IllegalArgumentException{

    public CreateDuplicateUserException(){
        super("This account number already exists");
    }
    public CreateDuplicateUserException(String message) {
        super(message);
    }
}
