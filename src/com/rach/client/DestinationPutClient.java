package com.rach.client;


import com.rach.resourcerepresentations.Destination;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedHashMap;

public class DestinationPutClient {

    private static final String BASE_URL
            = ClientUrlStringsUtility.SERVER_BASE_URL + "/service/destinationput";


    /**
     * PUT Sends the formData destination for update to service/destinationput/putdestinationwithformparams.
     *
     * @return the updated destination.
     */
    public static Destination putdestinationwithformparams() {
        Client client = ClientBuilder.newClient();
        MultivaluedHashMap<String, String> formData = new MultivaluedHashMap<>();
        formData.add("id", "D0001");
        formData.add("activity", "hard");
        formData.add("companion", "friend");
        formData.add("holidayType", "hot");
        formData.add("location", "Dubai");

        return client
                .target(BASE_URL).path("putdestinationwithformparams")
                .request(MediaType.APPLICATION_FORM_URLENCODED)
                .accept(MediaType.APPLICATION_JSON)
                .put(Entity.form(formData))
                .readEntity(Destination.class);
    }
}




