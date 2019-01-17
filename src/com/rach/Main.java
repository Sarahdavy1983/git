package com.rach;

import com.rach.client.*;
import com.rach.resourcerepresentations.Earthquake;
import com.rach.resourcerepresentations.Earthquakes;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {


//       System.out.println(">>> getwidget... \n" + WidgetGetClient.getwidget("50"));
//
//       System.out.println(">>> postwidgetswithjsonbody... \n" + WidgetPostClient.postwidgetswithjsonbody());
//        try {
//            System.out.println(">>> postwidgetswithjsonbodyandexceptions... \n" + WidgetPostClient.postwidgetswithjsonbodyandexceptions());
//        } catch (BadClientRequestException e) {
//            e.printStackTrace();
//        }
//        System.out.println(">>> postwidgetwithformparams... \n" + WidgetPostClient.postwidgetwithformparams());
//
//        System.out.println(">>> putwidgetwithformparams... \n" + WidgetPutClient.putwidgetwithformparams());
//
//        System.out.println(">>> deletewidget... \n" + WidgetDeleteClient.deletewidget("10").readEntity(String.class));
//
        System.out.println(">>> getdestination... \n" + DestinationGetClient.getdestination ("D0002"));
        System.out.println(">>> deletedestination... \n" + DestinationDeleteClient.deleteDestination("D0027").readEntity(String.class));
        System.out.println(">>> postdestinationwithformparams... \n" + DestinationPostClient.postdestinationwithformparams());

        System.out.println(">>> postdestinationwithjsonbody... \n" + DestinationPostClient.postdestinationswithjsonbody());
        try {
            System.out.println(">>> postdestinationswithjsonbodyandexceptions... \n" + DestinationPostClient.postdestinationswithjsonbodyandexceptions());
        } catch (BadClientRequestException e) {
            e.printStackTrace();
        }
        System.out.println(">>> putdestinationwithformparams... \n" + DestinationPutClient.putdestinationwithformparams());

//        getEarthquakes();

//        getEarthquakesDemoBuilderPattern1();

//        getEarthquakesDemoBuilderPattern2();


    }

    public static void getEarthquakes() {
        System.out.println(">>> getEarthquakes...");

        Earthquakes earthquakes = EarthquakeClient.getEarthquakes("44.1",
                "-9.9", "-22.4", "55.2");
        System.out.println("earthquakes.getEarthquakes().size() = " + earthquakes.getEarthquakes().size());

        for (Earthquake e : earthquakes.getEarthquakes()) {
            System.out.println(e.toString());
        }
    }

    public static void getEarthquakesDemoBuilderPattern1() {
        System.out.println(">>> getEarthquakesDemoBuilderPattern1...");

        Earthquakes earthquakes = EarthquakeClient.getEarthquakesDemoBuilderPattern1("44.1", "-9.9", "-22.4", "55.2");
        System.out.println("earthquakes.getEarthquakes().size() = " + earthquakes.getEarthquakes().size());

        for (Earthquake e : earthquakes.getEarthquakes()) {
            System.out.println(e.toString());
        }
    }

    public static void getEarthquakesDemoBuilderPattern2() {
        System.out.println(">>> getEarthquakesDemoBuilderPattern2...");

        Map<String, String> params = new HashMap<String, String>();
        params.put("north", "44.1");
        params.put("south", "-9.9");
        params.put("east", "-22.4");
        params.put("west", "55.2");
        params.put("username", ClientUrlStringsUtility.GEONAMES_USERNAME);

        Earthquakes earthquakes = EarthquakeClient.getEarthquakesDemoBuilderPattern2(params);
        System.out.println("earthquakes.getEarthquakes().size() = " + earthquakes.getEarthquakes().size());

        for (Earthquake e : earthquakes.getEarthquakes()) {
            System.out.println(e.toString());
        }
    }
}