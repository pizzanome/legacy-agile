package fr.pizzanome.agile;

import java.util.List;
import java.util.Map;

public class Plan {
    Map<Long,Intersection> intersections;
    List<Segment> segments;
    Intersection warehouse;

    public Plan(Map<Long, Intersection> intersections, List<Segment> segments, Intersection warehouse) {
        this.intersections = intersections;
        this.segments = segments;
        this.warehouse = warehouse;
    }
}
