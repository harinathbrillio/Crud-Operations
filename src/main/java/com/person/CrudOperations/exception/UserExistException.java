package com.person.CrudOperations.exception;

public class UserExistException extends RuntimeException {
    public UserExistException(String message){
        super(message);
    }
}
