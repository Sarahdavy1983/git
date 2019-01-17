package com.rach.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.Map;

public class GenericGetClient {


    public static <T extends Object> T getEarthquakes(String baseURL,
                                                      String path,
                                                      Map<String, String> queryParameters,
                                                      Class<T> type) {

        Client jaxClient = ClientBuilder.newClient();

        WebTarget jaxTarget = jaxClient.target(baseURL).path(path);

        for (String key : queryParameters.keySet()) {
            String value = queryParameters.get(key);
            jaxTarget = jaxTarget.queryParam(key, value);
        }

        T eq = (T) jaxTarget.request(MediaType.APPLICATION_FORM_URLENCODED)
                .accept(MediaType.APPLICATION_JSON)
                .get(type);

        return eq;
    }

}