package fr.pizzanome.agile;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XMLParser {

    public Plan parseXML(String path) throws IOException, JDOMException {
        SAXBuilder sxb = new SAXBuilder();
        Document document = sxb.build(path);

        Map<Long, Intersection> intersections = new HashMap<>();
        List<Segment> segments = new ArrayList<>();

        Element racine = document.getRootElement();

        List<Element> listeElementsIntersection = racine.getChildren("intersection");
        for (Element elementIntersection : listeElementsIntersection) {
            Intersection intersection = new Intersection(Long.parseLong(elementIntersection.getAttributeValue("id")),
                    Double.parseDouble(elementIntersection.getAttributeValue("latitude")),
                    Double.parseDouble(elementIntersection.getAttributeValue("longitude")));

            intersections.put(intersection.getId(), intersection);
        }

        List<Element> listeElementsSegment = racine.getChildren("segment");
        for (Element elementSegment : listeElementsSegment) {
            Segment segment = new Segment(intersections.get(Long.parseLong(elementSegment.getAttributeValue("destination"))),
                    Double.parseDouble(elementSegment.getAttributeValue("length")),
                    elementSegment.getAttributeValue("name"),
                    intersections.get(Long.parseLong(elementSegment.getAttributeValue("origin"))));

            segments.add(segment);
        }

        Element elementEntrepot = racine.getChildren("warehouse").get(0);
        Intersection entrepot = intersections.get(Long.parseLong(elementEntrepot.getAttributeValue("address")));

        return new Plan(intersections, segments, entrepot);
    }
}
