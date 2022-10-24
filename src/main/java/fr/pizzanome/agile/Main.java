package fr.pizzanome.agile;

import org.jdom2.JDOMException;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        XMLParser parser = new XMLParser();

        try {
            Plan plan = parser.parseXML("src/main/resources/smallMap.xml");

            System.out.println("Plan :");

            System.out.println("Intersections :");
            for (Intersection intersection : plan.getIntersections().values()) {
                System.out.println("id : " + intersection.getId() + " latitude : " + intersection.getLatitude() + " longitude : " + intersection.getLongitude());
            }

            System.out.println("Segments :");
            for (Segment segment : plan.getSegments()) {
                System.out.println("origin : " + segment.getOrigine().getId() + " destination : " + segment.getDestination().getId() + " length : " + segment.getTaille() + " name : " + segment.getNom());
            }

            System.out.println("Warehouse :");
            System.out.println("id : " + plan.getEntrepot().getId() + " latitude : " + plan.getEntrepot().getLatitude() + " longitude : " + plan.getEntrepot().getLongitude());
        } catch (IOException | JDOMException e) {
            System.err.println("Erreur lors de la lecture du fichier XML");
        }
    }
}
