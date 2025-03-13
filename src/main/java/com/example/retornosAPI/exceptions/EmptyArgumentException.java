package com.example.retornosAPI.exceptions;

public class EmptyArgumentException extends IllegalArgumentException{
    public EmptyArgumentException (String message){
        super(message);
    }
}
