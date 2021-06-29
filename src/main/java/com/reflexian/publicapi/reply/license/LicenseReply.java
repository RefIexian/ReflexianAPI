package com.reflexian.publicapi.reply.license;

import com.google.gson.JsonObject;
import com.reflexian.publicapi.reply.AbstractReply;

public class LicenseReply extends AbstractReply {

    private JsonObject response;

    public LicenseReply(JsonObject jsonObject) {
        this.response=jsonObject;
    }

    public JsonObject getResponse() {
        if (response == null || response.isJsonNull()) {
            return null;
        } else {
            return response.getAsJsonObject();
        }
    }

}
