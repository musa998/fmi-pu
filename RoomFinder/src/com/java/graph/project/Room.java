package com.java.graph.project;

import java.util.ArrayList;

public class Room {

    public int number;
    public int floorNumber;
    public int floor;
    public int x;
    public int y;
    public String roomType;
    public boolean canBePathTest= true;
    public boolean isPath = true;

    boolean isTested = false;
    ArrayList<Link> links = new ArrayList<>();
    double distance = Double.MAX_VALUE;
    int depth = -1;

    public Room(int number, int floorNumber, int x, int y, String roomType) {
        this.number = number;
        this.floor = floorNumber;
        this.x = x;
        this.y = y;
        this.roomType = roomType;
        setFloorNumber(number);
    }

    public Room(int number, int x, int y) {
        this.number = number;
        this.x = x;
        this.y = y;
        setFloorNumber(number);
    }
    public void setFloorNumber(int number){
        this.floorNumber = (int)number / 100;
    }
    public void addLink(Link link) {
        links.add(link);
    }
}
