package com.rach.client;

import com.rach.resourcerepresentations.Widget;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;

public class WidgetPutClient {

    private static final String BASE_URL
            = ClientUrlStringsUtility.SERVER_BASE_URL + "/service/widgetput";


    /**
     * PUT Sends the formData widget for update to service/widgetput/putwidgetwithformparams.
     *
     * @return the updated widget.
     */
    public static Widget putwidgetwithformparams() {
            Client client = ClientBuilder.newClient();
        MultivaluedHashMap<String, String> formData = new MultivaluedHashMap<>();
                    formData.add("id", "1");
                formData.add("name", "W102");
                formData.add("widthcms", "24");
                formData.add("heightcms", "25");
                formData.add("weightgms", "25.3");
                formData.add("value", "236");

        return client
                .target(BASE_URL).path("putwidgetwithformparams")
                .request(MediaType.APPLICATION_FORM_URLENCODED)
                .accept(MediaType.APPLICATION_JSON)
                .put(Entity.form(formData))
                .readEntity(Widget.class);
    }
    }


