package com.rach.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class DestinationDeleteClient {

    private static final String BASE_URL
            = ClientUrlStringsUtility.SERVER_BASE_URL + "/service/destinationdelete";

    /**
     * DELETE the destination with the given id.
     * request to resourcerepresentations at service/destinationdelete/deleteDestination
     *
     * @param destID
     * @return
     */
    public static Response deleteDestination(String destID) {
        Client client = ClientBuilder.newClient();
        return client.target(BASE_URL).path("deletedestination")
                .queryParam("id", destID)
                .request()
                .accept(MediaType.TEXT_PLAIN)
                .delete();

    }

}
