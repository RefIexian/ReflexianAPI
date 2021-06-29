package com.reflexian.publicapi.exceptions;

public class NotLicenseKeyException extends ReflexianException {

    public NotLicenseKeyException() {
        super("Your API key is not a license key!");
    }

}
