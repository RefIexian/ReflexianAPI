package com.reflexian.publicapi.license;

public class Information extends LicenseObject {

    public Information(){}

    public String getString() {
        return string;
    }

    public void setObject(String string ) {
        this.string = string;
    }

    protected String string;

}
