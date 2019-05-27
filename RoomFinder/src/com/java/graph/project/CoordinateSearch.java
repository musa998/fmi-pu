package com.java.graph.project;

import java.util.ArrayList;

public class CoordinateSearch extends BaseSearch {


    public CoordinateSearch(Building g) {
        super(g);
    }

    @Override
    public boolean checkForPath(int from, int to) {

        if(!graph.containsKey(from) ||
                !graph.containsKey(to)) {
            return false;
        }

        Room start = graph.get(from);

        ArrayList<Room> list = new ArrayList<>();

        ArrayList<Integer> roomsPath =  new ArrayList<>();

        list.add(start);

        while(!list.isEmpty()) {
            Room current = list.remove(0);

            System.out.println(current.number);

            if(current.number == to) {
//                printPath2(roomsPath);
                printPath(current);
                return true;
            }

            current.isTested = true;

            for(Link link : current.links) {

                if(link.to.depth == -1) {
                    link.to.depth = current.depth + 1;
                    System.out.println("DEPTH - "+link.to.number+" depth "+link.to.depth);

                }
                boolean canChangeFloor = changeFloor(current, link);

                if(!link.to.isTested &&
                        !list.contains(link.to) && canChangeFloor){
                    calculateDistance(link.to, graph.get(to));
                    addElement(link.to, list);
                }
            }
        }

        return false;
    }

    @Override
    public boolean checkForPath(int from, int to, String path) {
        return false;
    }

    public boolean changeFloor(Room current, Link link){
        if (current.roomType.equals("transit")){
            current.canBePathTest = false;
            return  true;
        }else if (current.floorNumber == link.to.floorNumber){
            current.canBePathTest = false;
            return true;
        }
        else if (current.canBePathTest){
//                    current.depth = -1;
//                    current.depth = 1;
            current.canBePathTest = false;
            current.isPath= false;
            return false;
        }
        return false;
    }



    private void calculateDistance(Room current, Room end) {
        double a = current.x - end.x;
        double b = current.y - end.y;
        int c = current.floorNumber;

        current.distance = Math.sqrt(a*a + b*b + c*c);

        System.err.println(current.number + "->" + current.distance);
    }

    private void addElement(Room to, ArrayList<Room> list) {

        for(int i = 0; i < list.size(); i++) {
            if(to.distance < list.get(i).distance) {
                list.add(i, to);
                return;
            }
        }

        list.add(to);

    }
}
