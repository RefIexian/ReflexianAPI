package com.reflexian.publicapi.license;

public class Record extends LicenseObject {

    public Record(){}

    protected boolean blacklisted=false;

    public boolean isBlacklisted() {
        return blacklisted;
    }

    public void setBlacklisted(boolean blacklisted) {
        this.blacklisted = blacklisted;
    }

    public String getBlacklistedReason() {
        return blacklistedReason;
    }

    public void setBlacklistedReason(String blacklistedReason) {
        this.blacklistedReason = blacklistedReason;
    }

    protected String blacklistedReason="N/A";

}
