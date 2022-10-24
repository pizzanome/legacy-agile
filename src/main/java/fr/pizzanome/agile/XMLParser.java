package fr.pizzanome.agile;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import javax.xml.soap.SOAPPart;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XMLParser {


    public Plan parseXML(String path) throws IOException, JDOMException {
        //On veut parser un fichier XML qui est compose de 2 balises principales : <intersections> et <segments>
        //On va donc creer 2 listes d'objets Intersection et Segment
        //On va ensuite parcourir le fichier XML et remplir la map ntersections avec une clé id et la liste segments
        //On va ensuite affecter les listes d'objets Intersection et Segment a this.intersections et this.segments

        SAXBuilder sxb = new SAXBuilder();
            Map<Long,Intersection> intersections= new HashMap<>();
            List<Segment> segments = new ArrayList<>();
            Intersection warehouse = null;

            Document document = sxb.build(path);
            Element racine = document.getRootElement();
            //Dans l'UML on a 2 balises principales : <intersections> et <segments>
            //<intersections> contient les attributs id, latitude et longitude Exemple : <intersection id="1" latitude="48.856614" longitude="2.3522219"/>
            //<segments> contient les attributs origin, destination, length et name Exemple : <segment origin="1" destination="2" length="0.1" name="rue de Rivoli"/>
            List<Element> listIntersections = racine.getChildren("intersection");
            for (Element intersection : listIntersections) {
                Intersection inter = new Intersection(Long.parseLong(intersection.getAttributeValue("id")),
                        Double.parseDouble(intersection.getAttributeValue("latitude")),
                        Double.parseDouble(intersection.getAttributeValue("longitude")));
                intersections.put(inter.id, inter);
            }

            List<Element> listSegments = racine.getChildren("segment");
            for (Element segment : listSegments) {
                Segment seg = new Segment(intersections.get(Long.parseLong(segment.getAttributeValue("destination"))),
                        Double.parseDouble(segment.getAttributeValue("length")),
                        segment.getAttributeValue("name"),
                        intersections.get(Long.parseLong(segment.getAttributeValue("origin"))));
                segments.add(seg);
            }
            List<Element> uneWarehouse= racine.getChildren("warehouse");
            for (Element warehouseElement : uneWarehouse) {
                warehouse = intersections.get(Long.parseLong(warehouseElement.getAttributeValue("address")));
            }
            Plan plan = new Plan(intersections, segments, warehouse);
            return plan;
    }
}
