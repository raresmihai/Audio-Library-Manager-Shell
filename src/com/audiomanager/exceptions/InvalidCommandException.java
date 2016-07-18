package com.audiomanager.exceptions;

/**
 * Created by rares on 19.03.2016.
 */
public class InvalidCommandException extends RuntimeException {
    public InvalidCommandException() {

    }

    public InvalidCommandException(String message) {
        super(message);
    }
}
