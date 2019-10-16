package com.asigment.discounts;

import java.util.Arrays;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] plants = Arrays.stream(input.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int numDays = input.nextInt();

        //System.out.println("Sorting Method: " + getTotalHarvestLeaves(plants, numDays));

        //System.out.println("Herb Garden Method: " + herbGarden(plants, numDays));
    }

    public static int getTotalHarvestLeaves(int[] plats, int numDays) {

        int totalLeaves = 0;
        for (int i = 0; i < numDays; i++) {
            // here we shuld sort the array to find the max number(plat with the most leaves)
            Arrays.sort(plats);
            // with the sorted array we can easly find with plant to harvest by substracting 1 from the array lenght
            int plantToHarvest = plats.length - 1;

            // in this variable we store the total leaves we harvest
            totalLeaves += (int) (plats[plantToHarvest] / 2);

            // in this line below we harvest the half lives of the plant
            plats[plantToHarvest] -= (int) (plats[plantToHarvest] / 2);

            // This is the end of the day and now every plant can grow with two more leaves
            for (int j = 0; j < plats.length; j++) {
                plats[j] += 2;
            }
        }
        return totalLeaves;
    }

    public static int herbGarden(int[] plants, int days) {
        int totalLeaves = 0;
        for (int i = 0; i < days; i++) {
            int plantToHarvest = getIndexOfLargest(plants);
            int leavesToHarvest = (int) (plants[plantToHarvest] / 2);

            totalLeaves += leavesToHarvest;
            plants[plantToHarvest] -= leavesToHarvest;

            for (int j = 0; j < plants.length; j++) {
                plants[j] += 2;
            }
        }
        return totalLeaves;
    }



    public static int getIndexOfLargest( int[] array )
    {
        if ( array == null || array.length == 0 ) return -1; // null or empty

        int largest = 0;
        for ( int i = 1; i < array.length; i++ )
        {
            if ( array[i] > array[largest] ) largest = i;
        }
        return largest; // position of the first largest found
    }



//    public static int getTotalHarvestLeaves2(int[] plats, int numDays, int index) {
//
//        if (index == numDays) {
//
//        } else {
//            int plantToHarvest = plantToHarvest(plats);
//            int leavesToTake = (int) (plats[plantToHarvest] / 2);
//            plats[plantToHarvest] -= leavesToTake;
//            res += leavesToTake;
//            for (int i = 0; i < plats.length; i++) {
//                plats[i] += 2;
//            }
//            getTotalHarvestLeaves2(plats, numDays, index+1);
//        }
//        return res;
//    }

//    static int plantToHarvest(int[] plants) {
//        int i;
//        // Initialize maximum element
//        int max = 0;
//        // Traverse array elements from second and
//        // compare every element with current max
//        for (i = 1; i < plants.length; i++)
//            if (plants[i] > plants[max])
//                max = i;
//
//        return max;
//    }
}
