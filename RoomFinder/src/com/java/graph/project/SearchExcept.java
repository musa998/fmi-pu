package com.java.graph.project;

import java.util.ArrayList;

public class SearchExcept extends BaseSearch {
    public SearchExcept(Building g) {
        super(g);
    }

    @Override
    public boolean checkForPath(int from, int to) {
        return false;
    }
    @Override
    public boolean checkForPath(int from, int to, String exceptPath) {

        if (!graph.containsKey(from) ||
                !graph.containsKey(to)) {
            return false;
        }

        Room start = graph.get(from);

        ArrayList<Room> list = new ArrayList<>();

        ArrayList<Integer> roomsPath = new ArrayList<>();

        list.add(start);

        while (!list.isEmpty()) {
            Room current = list.remove(0);

            System.out.println(current.number);

            if (current.number == to) {
//                printPath2(roomsPath);
                printPath3(current, from, exceptPath);
                return true;
            }

            current.isTested = true;

            for (Link link : current.links) {

                if (link.to.depth == -1) {
                    link.to.depth = current.depth + 1;
                    System.out.println("DEPTH - " + link.to.number + " depth " + link.to.depth);

                }
//                boolean canChangeFloor = changeFloor(current, link);

                if (!link.to.isTested &&
                        !list.contains(link.to)) {
//                    calculateDistance(link.to, graph.get(to));
                    addElement(link, list, exceptPath);
                }
            }
        }

        return false;
    }

    private void addElement(Link link, ArrayList<Room> list, String path) {
        for (int i = 0; i < list.size(); i++) {
            if (link.transition.equals(path)) {
//                list.add(i, to);
                return;
            } else {
                list.add(i, link.to);
                return;
            }
        }
        if (link.transition.equals(path) == false) {
            list.add(link.to);
        }

    }
}
