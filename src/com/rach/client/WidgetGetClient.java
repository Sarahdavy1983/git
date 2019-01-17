package com.rach.client;

import com.rach.resourcerepresentations.Widget;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

public class WidgetGetClient {

    private static final String BASE_URL
            = ClientUrlStringsUtility.SERVER_BASE_URL + "/service/widgetget";


    /**
     * GET widget by id at service/widgetget/getwidget.
     * @param id
     * @return the Widget with the given id.
     */
    public static Widget getwidget(String id) {
        Client client = ClientBuilder.newClient();
        return client
                .target(BASE_URL).path("getwidget")
                .queryParam("id", id)
                .request()
                .accept(MediaType.APPLICATION_JSON)
                .get(Widget.class);
    }
}
