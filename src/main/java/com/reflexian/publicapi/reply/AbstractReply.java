package com.reflexian.publicapi.reply;

public abstract class AbstractReply {

    public boolean isBlacklisted() {
        return blacklisted;
    }

    protected boolean blacklisted;
    protected boolean success;
    protected String cause;

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

    @Override
    public String toString() {
        return "AbstractReply{" +
                "success=" + success +
                ", cause=" + success +
                ", blacklisted='" + blacklisted + '\'' +
                '}';
    }
}
