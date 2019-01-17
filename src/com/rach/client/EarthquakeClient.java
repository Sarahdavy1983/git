package com.rach.client;

import com.rach.resourcerepresentations.Earthquakes;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.Map;

public class EarthquakeClient {

    private final static String BASE_URL = "http://api.geonames.org";
    private final static String PATH = "earthquakesJSON";
    private final static String USERNAME = ClientUrlStringsUtility.GEONAMES_USERNAME;

    /**
     * Gets the earthquake list. Client uses the builder pattern.
     * In this version, the target is accessed via the client and
     * each parameter is added one at a time.
     *
     * @param north
     * @param south
     * @param east
     * @param west
     * @return
     */
    public static Earthquakes getEarthquakes(String north, String south, String east, String west) {

        Client jaxClient = ClientBuilder.newClient();

        return jaxClient
                .target(BASE_URL).path(PATH)
                .queryParam("north", north)
                .queryParam("south", south)
                .queryParam("east", east)
                .queryParam("west", west)
                .queryParam("username", USERNAME)
                .request()
                .accept(MediaType.APPLICATION_JSON)
                .get(Earthquakes.class);
    }


    /**
     * Gets the earthquake list. WebTarget also uses the builder pattern.
     * In this version, we get the WebTarget from the client.
     * Each parameter is added one at a time.
     *
     * @param north
     * @param south
     * @param east
     * @param west
     * @return Earthquakes which contains List of Earthquake.
     */
    public static Earthquakes getEarthquakesDemoBuilderPattern1(String north,
                                                                String south,
                                                                String east,
                                                                String west) {

        Client jaxClient = ClientBuilder.newClient();

        WebTarget jaxTarget = jaxClient.target(BASE_URL).path(PATH);
        jaxTarget = jaxTarget.queryParam("north", north)
                .queryParam("south", south)
                .queryParam("east", east)
                .queryParam("west", west)
                .queryParam("username", USERNAME);

        System.out.println("getEarthquakesDemoBuilderPattern1...Final target string = " +
                jaxTarget.toString());

        return jaxTarget.request()
                .accept(MediaType.APPLICATION_JSON)
                .get(Earthquakes.class);

    }

    /**
     * Gets the earthquake list.
     * In this version, the parameters are added dynamically from a Map.
     *
     * @param queryParameters Map of String, String. The key is the name of the parameter,
     *                        the value is the value of the parameter.
     * @return Earthquakes which contains List of Earthquake.
     */
    public static Earthquakes getEarthquakesDemoBuilderPattern2(Map<String, String> queryParameters) {

        Client jaxClient = ClientBuilder.newClient();

        WebTarget jaxTarget = jaxClient.target(BASE_URL).path(PATH);
        for (String key : queryParameters.keySet()) {
            String value = queryParameters.get(key);
            jaxTarget = jaxTarget.queryParam(key, value);
        }
        jaxTarget = jaxTarget.queryParam("username", USERNAME);

        System.out.println("getEarthquakesDemoBuilderPattern2...Final target string = " +
                jaxTarget.toString());

        return jaxTarget.request()
                .accept(MediaType.APPLICATION_JSON)
                .get(Earthquakes.class);

    }
}
