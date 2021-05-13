package com.reflexian.publicapi.exceptions;

public class KeyBlacklistedException extends ReflexianException{

    public KeyBlacklistedException() {
        super("Your API key is blacklisted!");
    }

}
