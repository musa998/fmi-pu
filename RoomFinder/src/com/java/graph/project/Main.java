package com.java.graph.project;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);

        Building building = new Building();




        FileInputStream fstream = new FileInputStream("dexter+lab.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
        boolean detectEmptyLine = false;
        String strLine;
//Read File Line By Line
        while ((strLine = br.readLine()) != null) {
            if (strLine.isEmpty() || detectEmptyLine) {
                detectEmptyLine = true;
                boolean bidirectional = false;
                if (strLine.isEmpty()){
                    continue;
                }
                String[] inputTokens = Arrays.stream(strLine.split("[\\s,\\;]+"))
                        .map(String::toLowerCase)
                        .toArray(String[]::new);
                if (inputTokens[4].equals("yes")) {
                    bidirectional = true;
                }
                Integer from = Integer.parseInt(inputTokens[0]);
                Integer to = Integer.parseInt(inputTokens[1]);
                String path = inputTokens[2];
                int distance = Integer.parseInt(inputTokens[3]);
                building.createLink(from, to, bidirectional, distance, path);

            } else {
                String[] inputTokens = Arrays.stream(strLine.split("[\\s,\\;]+"))
                        .map(String::toLowerCase)
                        .toArray(String[]::new);
                Room room = new Room(Integer.parseInt(inputTokens[0]), Integer.parseInt(inputTokens[1]),
                        Integer.parseInt(inputTokens[2]), Integer.parseInt(inputTokens[3]), inputTokens[4]);
                building.addNodeToGraph(room);
            }
        }

//Close the input stream
            br.close();


        ///////////////////////////////////////////////////////////////////////////////

            System.out.println("Starting program");
//            while (input.hasNextLine()) {
//                System.out.println("Inside loop - read data");
//                String[] inputTokens = Arrays.stream(input.nextLine().split("[\\s,\\;]+"))
//                        .map(String::toLowerCase)
//                        .toArray(String[]::new);
//                if (inputTokens[0].equals("")) {
//                    System.out.println("breaking out of the loop");
//                    break;
//                }
//
//                Room room = new Room(Integer.parseInt(inputTokens[0]), Integer.parseInt(inputTokens[1]),
//                        Integer.parseInt(inputTokens[2]), Integer.parseInt(inputTokens[3]), inputTokens[4]);
//                building.addNodeToGraph(room);
//            }
//            System.out.println("Enterring loop INSERT Connections");
//
//            while (input.hasNextLine()) {
//                boolean bidirectional = false;
//                System.out.println("Inside loop - read data");
//                String[] inputTokens = Arrays.stream(input.nextLine().split("[\\s,\\;]+"))
//                        .map(String::toLowerCase)
//                        .toArray(String[]::new);
//                if (inputTokens[0].equals("")) {
////                System.out.println("breaking out of the loop");
//                    break;
//                }
//                if (inputTokens[4].equals("yes")) {
//                    bidirectional = true;
//                }
//                Integer from = Integer.parseInt(inputTokens[0]);
//                Integer to = Integer.parseInt(inputTokens[1]);
//                String path = inputTokens[2];
//                int distance = Integer.parseInt(inputTokens[3]);
//
//                building.createLink(from, to, bidirectional, distance, path);
//            }

            BaseSearch search =
                    new CoordinateSearch(building);

            if (search.checkForPath(100, 405)) {
                System.out.println("Path Found!");
            } else {
                System.out.println("No path found!");
            }

    }


}