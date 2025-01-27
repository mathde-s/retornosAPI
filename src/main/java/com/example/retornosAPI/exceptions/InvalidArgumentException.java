package com.example.retornosAPI.exceptions;

public class InvalidArgumentException extends IllegalArgumentException{
    public InvalidArgumentException (String message){
        super(message);
    }
}
