package fr.pizzanome.agile;

public class Segment {
    public Intersection destination;
    public double length;
    public String name;
    public Intersection origin;

    public Segment(Intersection destination, double length, String name, Intersection origin) {
        this.destination = destination;
        this.length = length;
        this.name = name;
        this.origin = origin;
    }
}
