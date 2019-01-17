package com.rach.client;

import com.rach.resourcerepresentations.Destination;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

public class DestinationGetClient {

    private static final String BASE_URL
            = ClientUrlStringsUtility.SERVER_BASE_URL + "/service/destinationget";


    /**
     * GET destination by id at service/destinationget/getdestination.
     * @param destID
     * @return the Client.Destination with the given location.
     */
    public static Destination getdestination(String destID) {
        Client client = ClientBuilder.newClient();
        return client
                .target(BASE_URL).path("getdestination")
                .queryParam("id",destID )
                .request()
                .accept(MediaType.APPLICATION_JSON)
                .get(Destination.class);
    }
}
