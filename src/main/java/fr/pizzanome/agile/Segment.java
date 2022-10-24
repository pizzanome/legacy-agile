package fr.pizzanome.agile;

public class Segment {

    private final Intersection destination;
    private final double taille;
    private final String nom;
    private final Intersection origine;

    public Segment(Intersection destination, double taille, String nom, Intersection origine) {
        this.destination = destination;
        this.taille = taille;
        this.nom = nom;
        this.origine = origine;
    }

    public Intersection getDestination() {
        return destination;
    }

    public double getTaille() {
        return taille;
    }

    public String getNom() {
        return nom;
    }

    public Intersection getOrigine() {
        return origine;
    }
}
