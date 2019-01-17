package com.rach.client;


import com.rach.resourcerepresentations.Activity;
import com.rach.resourcerepresentations.Companion;
import com.rach.resourcerepresentations.Destination;
import com.rach.resourcerepresentations.HolidayType;

import javax.ws.rs.client.*;
import javax.ws.rs.core.*;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

public class DestinationPostClient {

    private static final String BASE_URL
            = ClientUrlStringsUtility.SERVER_BASE_URL + "/service/destinationpost";

    /**
     * POST Posts a list of Destinations to service/destinationpost/postdestinationswithjsonbody
     * The client post() method deserialises the list to JSON for transport.
     * The service returns the list of newly created destinations as JSON, each having an id.
     * The readEntity() method converts the JSON to a List by passing a anonymous inner-class
     * of GenericType - the Json is then mapped to List of Client.Destination.
     *
     * @return destinations in a List.
     */
    public static List<Destination> postdestinationswithjsonbody() {
        Destination newD1 = new Destination();

        newD1.setActivity(Activity.hard);
        newD1.setCompanion(Companion.family);
        newD1.setHolidayType(HolidayType.cold);
        newD1.setLocation("Andora");

        Destination newD2 = new Destination();

        newD2.setActivity(Activity.hard);
        newD2.setCompanion(Companion.family);
        newD2.setHolidayType(HolidayType.cold);
        newD2.setLocation("France");

        List<Destination> destinationsForPost = new ArrayList<>();
        destinationsForPost.add(newD1);
        destinationsForPost.add(newD2);

        Client client = ClientBuilder.newClient();
        return client
                .target(BASE_URL)
                .path("postdestinationswithjsonbody")
                .request(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .post(Entity.json(destinationsForPost))
                .readEntity(new GenericType<List<Destination>>(){});
    }
        /**
     * POST Posts a list of Destinations to service/destinationpost/postdestinationswithjsonbody
     * The same as above, however, this version breaks down Client, WebTarget, Invocation
     * and Response objects in order to perform exception handling.
     *
     * @return destinations in a List.
     * @throws BadClientRequestException
     */
    public static List<Destination> postdestinationswithjsonbodyandexceptions() throws BadClientRequestException {
        Destination newD1 = new Destination();

        newD1.setActivity(Activity.hard);
        newD1.setCompanion(Companion.family);
        newD1.setHolidayType(HolidayType.cold);
        newD1.setLocation("Andora");

        Destination newD2 = new Destination();

        newD2.setActivity(Activity.hard);
        newD2.setCompanion(Companion.family);
        newD2.setHolidayType(HolidayType.cold);
        newD2.setLocation("France");

        List<Destination> destinationsForPost = new ArrayList<>();
        destinationsForPost.add(newD1);
        destinationsForPost.add(newD2);

        Client client = ClientBuilder.newClient();

        WebTarget target = client.target(BASE_URL)
                .path("forceerror");
        //.path("postdestinationwithjsonbody");

        Invocation.Builder builder = target.request(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);

        Response response = builder.post(Entity.json(destinationsForPost));

        if (response.getStatus() == Response.Status.OK.getStatusCode() ||
                response.getStatus() == Response.Status.CREATED.getStatusCode()) {
            return response.readEntity(new GenericType<List<Destination>>() {
            });
        } else if (response.getStatus() == Response.Status.BAD_REQUEST.getStatusCode()) {
            throw new BadClientRequestException("BAD CLIENT REQUEST" + response.readEntity(Object.class));
        } else if (response.getStatus() == Response.Status.CONFLICT.getStatusCode()) {
            throw new BadClientRequestException("CONFLICT " + response.readEntity(Object.class));
        } else if (response.getStatus() == Response.Status.EXPECTATION_FAILED.getStatusCode()) {
            throw new BadClientRequestException("EXPECTATION_FAILED " + response.readEntity(Object.class));
        } else {
            throw new BadClientRequestException("Some other response code " + response);
        }

    }


    /**
     * POST Posts a destination to service/destinationpost/postdestinationwithformparams
     * Using javax.ws.rs.core.MultivalueMap (formData) to store each key/value pair
     * containing the destination attributes.
     * The formData in the request() is url-encoded and is then added to the request
     * body via post().
     *
     * @return the posted destination.
     */
    public static Destination postdestinationwithformparams() {

        Client client = ClientBuilder.newClient();
        MultivaluedHashMap<String, String> formData = new MultivaluedHashMap<>();

        formData.add("activity", "hard");
        formData.add("companion", "friend");
        formData.add("holidayType", "hot");
        formData.add("location", "Dubai");

        return client
                .target(BASE_URL).path("postdestinationwithformparams")
                .request(MediaType.APPLICATION_FORM_URLENCODED)
                .accept(MediaType.APPLICATION_JSON)
                .post(Entity.form(formData))
                .readEntity(Destination.class);
    }

    }



