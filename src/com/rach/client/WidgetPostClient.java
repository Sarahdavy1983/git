package com.rach.client;

import com.rach.resourcerepresentations.Widget;

import javax.ws.rs.client.*;
import javax.ws.rs.core.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class WidgetPostClient {

    private static final String BASE_URL
            = ClientUrlStringsUtility.SERVER_BASE_URL + "/service/widgetpost";

    /**
     * POST Posts a list of Widgets to service/widgetpost/postwidgetswithjsonbody
     * The client post() method deserialises the list to JSON for transport.
     * The service returns the list of newly created widgets as JSON, each having an id.
     * The readEntity() method converts the JSON to a List by passing a annonyous inner-class
     * of GenericType - the Json is then mapped to List of Widget.
     *
     * @return widgets in a List.
     */
    public static List<Widget> postwidgetswithjsonbody() {
        Widget newW1 = new Widget();
        newW1.setName("W1");
        newW1.setWidthcms(1);
        newW1.setHeightcms(1);
        newW1.setWeightgms(1);
        newW1.setValue(new BigDecimal(1));

        Widget newW2 = new Widget();
        newW2.setName("W2");
        newW2.setWidthcms(2);
        newW2.setHeightcms(2);
        newW2.setWeightgms(2);
        newW2.setValue(new BigDecimal(2));

        List<Widget> widgetsForPost = new ArrayList<>();
        widgetsForPost.add(newW1);
        widgetsForPost.add(newW2);

        Client client = ClientBuilder.newClient();
        return client
                .target(BASE_URL)
                .path("postwidgetswithjsonbody")
                .request(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .post(Entity.json(widgetsForPost))
                .readEntity(new GenericType<List<Widget>>(){});
    }
        /**
     * POST Posts a list of Widgets to service/widgetpost/postwidgetswithjsonbody
     * The same as above, however, this version breaks down Client, WebTarget, Invocation
     * and Response objects in order to perform exception handling.
     *
     * @return widgets in a List.
     * @throws BadClientRequestException
     */
        public static List<Widget> postwidgetswithjsonbodyandexceptions() throws BadClientRequestException {

            Widget newW1 = new Widget();
            newW1.setName("W1");
            newW1.setWidthcms(1);
            newW1.setHeightcms(1);
            newW1.setWeightgms(1);
            newW1.setValue(new BigDecimal(1));

            Widget newW2 = new Widget();
            newW2.setName("W2");
            newW2.setWidthcms(2);
            newW2.setHeightcms(2);
            newW2.setWeightgms(2);
            newW2.setValue(new BigDecimal(2));

            List<Widget> widgetsForPost = new ArrayList<Widget>();
            widgetsForPost.add(newW1);
            widgetsForPost.add(newW2);

            Client client = ClientBuilder.newClient();

            WebTarget target = client.target(BASE_URL)
                    .path("forceerror");
                    //.path("postwidgetswithjsonbody");

            Invocation.Builder builder = target.request(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON);

            Response response = builder.post(Entity.json(widgetsForPost));

            if (response.getStatus() == Response.Status.OK.getStatusCode() ||
                    response.getStatus() == Response.Status.CREATED.getStatusCode()) {
                return response.readEntity(new GenericType<List<Widget>>() {
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
     * POST Posts a widget to service/widgetpost/postwidgetwithformparams
     * Using javax.ws.rs.core.MultivalueMap (formData) to store each key/value pair
     * containing the widget attributes.
     * The formData in the request() is url-encoded and is then added to the request
     * body via post().
     *
     * @return the posted widget.
     */
    public static Widget postwidgetwithformparams() {
        //TODO
        Client client = ClientBuilder.newClient();
        MultivaluedHashMap<String, String> formData = new MultivaluedHashMap<>();
        formData.add("id", "101");
        formData.add("name", "W101");
        formData.add("widthcms", "23");
        formData.add("heightcms", "25");
        formData.add("weightgms", "25.3");
        formData.add("value", "236");

        return client
                .target(BASE_URL).path("postwidgetwithformparams")
                .request(MediaType.APPLICATION_FORM_URLENCODED)
                .accept(MediaType.APPLICATION_JSON)
                .post(Entity.form(formData))
                .readEntity(Widget.class);
    }

    }



