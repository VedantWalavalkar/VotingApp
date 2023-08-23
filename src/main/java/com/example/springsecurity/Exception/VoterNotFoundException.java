package com.example.springsecurity.Exception;

public class VoterNotFoundException extends RuntimeException{
    public VoterNotFoundException(String message)
    {
        super(message);
    }
}
