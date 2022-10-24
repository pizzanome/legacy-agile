package fr.pizzanome.agile;

import org.jdom2.JDOMException;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        XMLParser parser = new XMLParser();

        try {
            Plan plan = parser.parseXML("src/main/resources/smallMap.xml");
            //Print the plan info
            System.out.println("Plan :");
            System.out.println("Intersections :");
            for (Intersection intersection : plan.intersections.values()) {
                System.out.println("id : " + intersection.id + " latitude : " + intersection.latitude + " longitude : " + intersection.longitude);
            }
            System.out.println("Segments :");
            for (Segment segment : plan.segments) {
                System.out.println("origin : " + segment.origin.id + " destination : " + segment.destination.id + " length : " + segment.length + " name : " + segment.name);
            }
            System.out.println("Warehouse :");
            System.out.println("id : " + plan.warehouse.id + " latitude : " + plan.warehouse.latitude + " longitude : " + plan.warehouse.longitude);
        } catch (IOException | JDOMException e) {
            System.out.println("Erreur lors de la lecture du fichier XML");
        }
    }
}
