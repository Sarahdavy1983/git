package com.rach.client;

import com.rach.resourcerepresentations.Widget;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class WidgetDeleteClient {

    private static final String BASE_URL
            = ClientUrlStringsUtility.SERVER_BASE_URL + "/service/widgetdelete";

    /**
     * DELETE the widget with the given id.
     * request to resourcerepresentations at service/widgetdelete/deletewidget
     *
     * @param id
     * @return
     */
    public static Response deletewidget(String id) {
        Client client = ClientBuilder.newClient();
        return client.target(BASE_URL).path("deletewidget")
                .queryParam("id", id)
                .request()
                .accept(MediaType.TEXT_PLAIN)
                .delete();

    }

}
