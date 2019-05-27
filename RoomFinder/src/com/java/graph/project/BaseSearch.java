package com.java.graph.project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public abstract class BaseSearch {

    HashMap<Integer, Room> graph;


    public BaseSearch(Building g) {
        graph = g.graph;

    }

    public abstract boolean checkForPath(int from, int to);

    public abstract boolean checkForPath(int from, int to, String path);

    public void resetFlags() {
        for (Room node : graph.values()) {
            node.isTested = false;
        }
    }

    protected void printPath3(Room current, int from, String pathExcept) {
        String res = "Path is: ";
        int costs = 0;
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Link> links = new ArrayList<>();
        ArrayList<Integer> allCurrentElements = new ArrayList<>();
        boolean partFromPath = false;
        checkLastLink(current, from, links);
        while (current.depth != 0) {
            list.add(current.number);
            allCurrentElements.add(current.number);
            for (Link link : current.links) {

                Link linkToAdd = null;
                if (link.to.depth == current.depth - 1) {
//                    for (Link link1 : current.links) {
                    if(!link.transition.equals(pathExcept) && !allCurrentElements.contains(link.to.number)) {
//                            link1.isTested = true;
                        linkToAdd = link;
                        links.add(linkToAdd);
                        current = link.to;
                        partFromPath = true;
//                        allCurrentElements.add(current.number);
                        break;
                    } else {
//                        partFromPath = false;
                        for (Link link1 : current.links) {
                            if (link1.to.depth != -1 && link1.to.depth > current.depth){
                                linkToAdd = link1;
                                links.add(link1);
                                current = link1.to;
//                                allCurrentElements.add(current.number);
                                link1.to.isPath = false;
                            }
                            else if (link1.to.depth == current.depth - 1 && !allCurrentElements.contains(link1.to.number)){
                                linkToAdd = link1;
                                links.add(link1);
                                current = link1.to;
                            }
                        }
//

                    }
//                    }
//                    if (partFromPath == false) {
//                        linkToAdd = link;
//                        links.add(linkToAdd);
//                        current = link.to;
//                        break;
//                    }
                }

            }
            checkLastLink(current, from, links);
        }
        list.add(current.number);
        String ress = "Path - ";
        for (int i = list.size(); i > 0; i--) {
            ress += list.get(i - 1) + " ";
        }
        for (Link link : links) {
            costs += link.distance;
        }
        System.out.println("Links size - " + links.size());
        System.out.println("Costs - " + costs);
        System.out.println(ress);
    }

    protected void printPath2(Room current, int from) {
        String res = "Path is: ";
        int costs = 0;
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Link> links = new ArrayList<>();
        boolean partFromPath = false;
        checkLastLink(current, from, links);
        while (current.depth != 0) {
            list.add(current.number);
            for (Link link : current.links) {

                Link linkToAdd = null;
                if (link.to.depth == current.depth - 1) {
                    for (Link link1 : current.links) {
                        if (link1.to.number == link.to.number && link1.transition.equals("lift")) {
                            linkToAdd = link1;
                            links.add(linkToAdd);
                            current = link.to;
                            partFromPath = true;
                            break;
                        } else {
                            partFromPath = false;
                        }
                    }
                    if (partFromPath == false) {
                        linkToAdd = link;
                        links.add(linkToAdd);
                        current = link.to;
                        break;
                    }
                }

            }
            checkLastLink(current, from, links);
        }
        list.add(current.number);
        String ress = "Path - ";
        for (int i = list.size(); i > 0; i--) {
            ress += list.get(i - 1) + " ";
        }
        for (Link link : links) {
            costs += link.distance;
        }
        System.out.println("Links size - " + links.size());
        System.out.println("Costs - " + costs);
        System.out.println(ress);
    }


    private void checkLastLink(Room current, int from, ArrayList<Link> links) {
        if (current.depth == 0) {
            Room finalCurrent = current;
            current.links.stream().forEach(link -> {
                if (hasDuplicates(finalCurrent.links, from)) {
                    if (link.to.number == from && link.transition.equals("lift")) {
                        links.add(link);
                    }
                } else if (link.to.number == from) {
                    links.add(link);
                }
            });
        }
    }

    private boolean hasDuplicates(ArrayList<Link> links, int comparator) {
        int res = 0;
        for (Link link : links) {
            if (link.to.number == comparator) {
                res++;
            }
        }
        if (res > 1) {
            return true;
        }
        return false;
    }

    protected void printPath(Room current) {
//        StringBuilder sb = new StringBuilder();
        int costs = 0;
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Link> links = new ArrayList<>();
        boolean currentIncreased = false;


        while (current.depth != 0) {
//                sb.append(current.number);
//                sb.append(",");
            list.add(current.number);
            for (Link link : current.links) {

                if (link.to.roomType.equals("room") && link.to.floorNumber != current.floorNumber
                        && currentIncreased == false) {
                    current.depth++;
                    continue;
                }

                if (link.to.depth == current.depth - 1) {

                    links.add(link);
                    current = link.to;
                    currentIncreased = true;
                    break;
                }
            }
        }
        list.add(current.number);
//        sb.append(current.number);
        String res = "Path - ";
        for (int i = list.size(); i > 0; i--) {
            res += list.get(i - 1) + " ";
        }
        for (Link link : links) {
            costs += link.distance;
        }
        System.out.println("Costs - " + costs);
        System.out.println("Link size - " + links.size());
        System.out.println(res);
//        System.out.println("The path is:" + sb);

    }
}
