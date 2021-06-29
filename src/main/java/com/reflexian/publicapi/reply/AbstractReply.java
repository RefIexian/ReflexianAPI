package com.reflexian.publicapi.reply;

public abstract class AbstractReply {

    public boolean isBlacklisted() {
        return blacklisted;
    }

    protected boolean blacklisted;
    protected boolean success;
    protected String cause;
    protected boolean licenseKeyError;

    public boolean isThrottled() {
        return throttled;
    }

    protected boolean throttled;


    public boolean isSuccess() {
        return success;
    }

    public String getCause() {
        return cause;
    }

    public boolean isLicenseKeyError() {
        return licenseKeyError;
    }

    @Override
    public String toString() {
        return "AbstractReply{" +
                "success=" + success +
                ", cause=" + success +
                ", blacklisted='" + blacklisted + '\'' +
                '}';
    }
}
