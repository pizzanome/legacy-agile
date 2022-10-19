package fr.pizzanome.agile;

import org.jdom2.JDOMException;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        XMLParser parser = new XMLParser();
        try {
            parser.parseXML("src/main/resources/smallMap.xml");
        } catch (IOException | JDOMException e) {
            System.out.println("Erreur lors de la lecture du fichier XML");
        }
    }
}
