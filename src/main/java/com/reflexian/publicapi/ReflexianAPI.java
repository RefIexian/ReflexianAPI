package com.reflexian.publicapi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.reflexian.publicapi.adapters.DateTimeTypeAdapter;
import com.reflexian.publicapi.adapters.UUIDTypeAdapter;
import com.reflexian.publicapi.exceptions.APIThrottleException;
import com.reflexian.publicapi.exceptions.KeyBlacklistedException;
import com.reflexian.publicapi.exceptions.ReflexianException;
import com.reflexian.publicapi.reply.AbstractReply;
import com.reflexian.publicapi.reply.prison.PlayerReply;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.time.ZonedDateTime;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ReflexianAPI {

    private static ReflexianAPI reflexianAPI;

    private static final String BASE_URL = "https://api.reflexian.com/";
    private final String apiKey;
    private static final Gson GSON = new GsonBuilder()
            .registerTypeAdapter(UUID.class, new UUIDTypeAdapter())
            .registerTypeAdapter(ZonedDateTime.class, new DateTimeTypeAdapter())
            .create();

    private final ExecutorService executorService;
    private final HttpClient httpClient;

    public ReflexianAPI(String apiKey) {
        this.apiKey = apiKey;

        this.executorService = Executors.newCachedThreadPool();
        this.httpClient = HttpClientBuilder.create().build();
    }

    /**
     * @param uuid uuid of a player in string format, can be both dashed or undashed.
     * @return the future
     */
    public CompletableFuture<PlayerReply> getPlayerByUuid(String uuid) {
        return get(PlayerReply.class, "player", uuid);
    }


    private <R extends AbstractReply> CompletableFuture<R> get(Class<R> clazz, String request, String params) {
        CompletableFuture<R> future = new CompletableFuture<>();
        try {
            if (params==null|| params.equals(""))
                throw new IllegalArgumentException("Need both key and value for parameters");

            StringBuilder url = new StringBuilder(BASE_URL);

            url.append("api/v1/");

            url.append(request);
            url.append("/").append(params);
            url.append("?key=").append(apiKey);

            executorService.submit(() -> {
                try {
                    R response = httpClient.execute(new HttpGet(url.toString()), obj -> {
                        String content = EntityUtils.toString(obj.getEntity(), "UTF-8");
                        if (clazz == PlayerReply.class) {
                            return (R) new PlayerReply(GSON.fromJson(content, JsonObject.class));
                        } else {
                            return GSON.fromJson(content, clazz);
                        }
                    });

                    checkReply(response);

                    future.complete(response);
                } catch (Throwable t) {
                    future.completeExceptionally(t);
                }
            });
        } catch (Throwable throwable) {
            future.completeExceptionally(throwable);
        }
        return future;
    }

    private <T extends AbstractReply> void checkReply(T reply) {
        if (reply != null) {
            if (reply.isThrottled()) {
                throw new APIThrottleException();
            } else if (reply.isBlacklisted()) {
                throw new KeyBlacklistedException();
            } else if (!reply.isSuccess()) {
                throw new ReflexianException(reply.getCause());
            }
        }
    }

}
