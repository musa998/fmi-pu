package com.java.graph.project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Building building = new Building();


        System.out.println("Enterring loop INSERT ROOMS");
        while (input.hasNextLine()) {
            System.out.println("Inside loop - read data");
            String[] inputTokens = Arrays.stream(input.nextLine().split("[\\s,\\;]+"))
                    .map(String::toLowerCase)
                    .toArray(String[]::new);
            if (inputTokens[0].equals("")) {
                System.out.println("breaking out of the loop");
                break;
            }

            Room room = new Room(Integer.parseInt(inputTokens[0]), Integer.parseInt(inputTokens[1]),
                    Integer.parseInt(inputTokens[2]), Integer.parseInt(inputTokens[3]), inputTokens[4]);
            building.addNodeToGraph(room);
        }
        System.out.println("Enterring loop INSERT Connections");

        while (input.hasNextLine()) {
            boolean bidirectional = false;
            System.out.println("Inside loop - read data");
            String[] inputTokens = Arrays.stream(input.nextLine().split("[\\s,\\;]+"))
                    .map(String::toLowerCase)
                    .toArray(String[]::new);
            if (inputTokens[0].equals("")) {
//                System.out.println("breaking out of the loop");
                break;
            }
            if (inputTokens[4].equals("yes")) {
                bidirectional = true;
            }
            Integer from = Integer.parseInt(inputTokens[0]);
            Integer to = Integer.parseInt(inputTokens[1]);
            String path = inputTokens[2];
            int distance = Integer.parseInt(inputTokens[3]);

            building.createLink(from, to, bidirectional, distance, path);
        }

        BaseSearch search =
                new SearchExcept(building);

        if(search.checkForPath(500, 304, "lift")) {
            System.out.println("Path Found!");
        }else {
            System.out.println("No path found!");
        }

    }
}
