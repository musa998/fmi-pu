package com.java.graph.project;

import java.util.ArrayList;

public class OnlyLiftSearch extends BaseSearch {

    public OnlyLiftSearch(Building g) {
        super(g);
    }

    @Override
    public boolean checkForPath(int from, int to) {

        if (!graph.containsKey(from) ||
                !graph.containsKey(to)) {
            return false;
        }

        Room start = graph.get(from);

        ArrayList<Room> queue = new ArrayList<>();

        queue.add(start);

        while (!queue.isEmpty()) {
            Room current = queue.remove(0);

            current.isTested = true;

            System.out.println(current.number);

            if (current.number == to) {
                printPath2(current, from);
                return true;
            }

            for (Link link : current.links) {

                if (link.to.depth == -1) {
                    link.to.depth = current.depth + 1;
//                    System.out.println("DEPTH - " + link.to.number + " depth " + link.to.depth);
//                    if (link.to.number == start.number){
//                        link.to.depth = -1;
//                    }
                }

                boolean canChangeFloor = changeFloor(current, link);

                if (!link.to.isTested &&
                        !queue.contains(link.to)) {
//                    queue.add(link.to);
                    addElement(link, queue);
                }
            }
//            addElement(current, queue);
        }

        return false;
    }

    @Override
    public boolean checkForPath(int from, int to, String path) {
        return false;
    }

    private boolean changeFloor(Room current, Link link) {
        if (current.roomType.equals("transit")) {
            current.canBePathTest = false;
            return true;
        } else if (current.floorNumber == link.to.floorNumber) {
            current.canBePathTest = false;
            return true;
        } else if (current.canBePathTest) {
//                    current.depth = -1;
//                    current.depth = 1;
            current.canBePathTest = false;
            current.isPath = false;
            return false;
        }
        return false;
    }

    private void addElement(Link link, ArrayList<Room> list) {
        for (int i = 0; i < list.size(); i++) {
            if (link.transition.equals("lift")) {
                list.add(i, link.to);
                return;
            }

        }
        list.add(link.to);

    }

}
