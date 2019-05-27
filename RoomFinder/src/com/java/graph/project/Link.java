package com.java.graph.project;

public class Link {

    public Room to;
    public double distance;
    public String transition;
    public  boolean isTested;

    public Link(Room to, double distance, String transition) {
        this.to = to;
        this.distance = distance;
        this.transition = transition;
    }

    public Link(Room to) {
        this.to = to;
    }
}
