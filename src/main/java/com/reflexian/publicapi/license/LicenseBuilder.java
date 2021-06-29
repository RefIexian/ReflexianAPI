package com.reflexian.publicapi.license;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

public class LicenseBuilder {
    protected Record record;
    protected Information information;
    protected Client client;
    protected Product product;

    public LicenseBuilder(){
        record=new Record();
        client=new Client();
        information=new Information();
        product=new Product();
    }

    public Client getClient() {
        return client;
    }
    public Product getProduct() {
        return product;
    }
    public Information getInformation() {
        return information;
    }
    public Record getRecord() {
        return record;
    }



    public String toJson(){
        JsonObject jsonObject = new JsonObject();
        JsonObject clientO = new JsonObject();
        JsonObject recordO = new JsonObject();
        JsonObject informationO = new JsonObject();
        JsonObject productO = new JsonObject();
        JsonObject pricingO = new JsonObject();

        if (client.getDiscordId()!=0) clientO.addProperty("discordId", client.getDiscordId());
        if (client.getDiscordTag()!=null) clientO.addProperty("discordTag", client.getDiscordTag());
        if (client.getMinecraftUuid()!=null) clientO.addProperty("minecraftUuid", client.getMinecraftUuid());
        jsonObject.add("client", clientO);

        recordO.addProperty("blacklisted", record.isBlacklisted());
        recordO.addProperty("blacklistReason", record.getBlacklistedReason());
        jsonObject.add("record", recordO);

        if (information.getString()!=null) informationO.addProperty("info", information.getString());
        jsonObject.add("information", informationO);

        if (product.getType()!=null) productO.addProperty("type", product.getType());
        if (product.getDescription()!=null) productO.addProperty("description", product.getDescription());
        if (product.getVersion()!=null) productO.addProperty("version", product.getVersion());

        
        if (product.getPricing()!=null) {
            if (product.getPricing().getPrice()!=0) pricingO.addProperty("price", product.getPricing().getPrice());
            if (product.getPricing().getCurrency()!=null) pricingO.addProperty("currency", product.getPricing().getCurrency());
            if (product.getPricing().getMethod()!=null) pricingO.addProperty("method", product.getPricing().getMethod());
            productO.add("pricing", pricingO);
        }

        if (product.getDateStart()!=0) productO.addProperty("dateStart", product.getDateStart());
        if (product.getDateEnd()!=0) productO.addProperty("dateEnd", product.getDateEnd());
        jsonObject.add("product", productO);

        String json = jsonObject.toString().replace("\\\"","\"");
        return json;
    }
}
