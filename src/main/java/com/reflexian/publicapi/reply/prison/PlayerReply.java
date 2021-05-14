package com.reflexian.publicapi.reply.prison;

import com.google.gson.JsonObject;
import com.reflexian.publicapi.reply.AbstractReply;

public class PlayerReply extends AbstractReply {

    private long lastUpdated;
    private JsonObject response;

    public PlayerReply(JsonObject response) {
        this.response = response;
        this.success = response.has("success") && response.get("success").getAsBoolean();
        this.cause = response.has("cause") ? response.get("cause").getAsString() : null;
        this.throttled = response.has("cause") && response.get("cause").getAsString().contains("rate");
        this.lastUpdated = response.has("lastUpdated") ? response.get("lastUpdated").getAsLong() : -1;
    }

    public JsonObject getResponse() {
        if (response == null || response.isJsonNull()) {
            return null;
        } else {
            return response.getAsJsonObject();
        }
    }

    public long getLastUpdated() {
        return lastUpdated;
    }

    @Override
    public String toString() {
        return "ResourceReply{" +
                "lastUpdated=" + lastUpdated +
                ", response=" + response +
                "} " + super.toString();
    }

}
