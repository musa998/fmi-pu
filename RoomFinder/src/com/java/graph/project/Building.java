package com.java.graph.project;

import java.util.HashMap;

public class Building {
    HashMap<Integer, Room> graph = new HashMap<>();


    public void addNodeToGraph(Room node) {

        if (graph.containsKey(node.number)) {
            System.err.println("Node is duplicated!");
            return;
        }
        graph.put(node.number, node);
    }
    public void createLink(Integer from, Integer to, boolean bidirectional, int distance, String transition) {

        Room start = graph.get(from);
        Room end = graph.get(to);

        if (start != null && end != null) {
            start.addLink(new Link(end, distance, transition));

            if (bidirectional) {
                end.addLink(new Link(start, distance, transition));
            }
        }
    }


    public void createLink(Integer from, Integer to, boolean bidirectional) {

        Room start = graph.get(from);
        Room end = graph.get(to);

        if (start != null && end != null) {
            start.addLink(new Link(end));

            if (bidirectional) {
                end.addLink(new Link(start));
            }

        }
    }
}
