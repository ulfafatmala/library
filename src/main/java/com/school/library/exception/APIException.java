package com.school.library.exception;

public class APIException extends RuntimeException
{
    public APIException(String message)
    {
        super(message);
    }
}
