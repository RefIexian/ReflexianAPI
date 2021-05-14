package com.reflexian.publicapi.exceptions;

public class APIThrottleException extends ReflexianException {
    public APIThrottleException() {
        super("You have reached the API rate limit!");
    }
}
