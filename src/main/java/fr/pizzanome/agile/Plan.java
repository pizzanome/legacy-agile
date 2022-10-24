package fr.pizzanome.agile;

import java.util.List;
import java.util.Map;

public class Plan {

    private final Map<Long,Intersection> intersections;
    private final List<Segment> segments;
    private final Intersection entrepot;

    public Plan(Map<Long, Intersection> intersections, List<Segment> segments, Intersection entrepot) {
        this.intersections = intersections;
        this.segments = segments;
        this.entrepot = entrepot;
    }

    public Map<Long, Intersection> getIntersections() {
        return intersections;
    }

    public List<Segment> getSegments() {
        return segments;
    }

    public Intersection getEntrepot() {
        return entrepot;
    }
}
