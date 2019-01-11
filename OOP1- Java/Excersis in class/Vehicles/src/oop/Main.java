package oop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class Main {

    public static final String TYPE_CAR = "Car";
    public static final String TYPE_TRUCK = "Truck";
    public static final String COMMAND_DRIVE = "Drive";
    public static final String COMMAND_REFUEL = "Refuel";
    public static final String TYPE_BUS = "Bus";
    public static final String COMMAND_DRIVE_EMPTY = "DriveEmpty";

    static final double BUS_EXTRA_CONSUPTION = 1.4;
    static double CAR_SUMMER_EXTRA_CONSUPTION = 0.9;
    static double TRUCK_SUMMER_EXTRA_CONSUPTION = 1.6;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] carTokens = reader.readLine().split(" ");
        String[] truckTokens = reader.readLine().split(" ");
        String[] busTokens = reader.readLine().split(" ");

        Vehicle car = new Car(Double.parseDouble(carTokens[1]),
                (Double.parseDouble(carTokens[2]) + CAR_SUMMER_EXTRA_CONSUPTION), Double.parseDouble(carTokens[3]));
        Vehicle truck = new Truck(Double.parseDouble(truckTokens[1]),
                Double.parseDouble(truckTokens[2]) + TRUCK_SUMMER_EXTRA_CONSUPTION, Double.parseDouble(truckTokens[3]));
        Vehicle bus = new Bus(Double.parseDouble(busTokens[1]),
                Double.parseDouble(busTokens[2]), Double.parseDouble(busTokens[3]));

        int n = Integer.parseInt(reader.readLine());

        DecimalFormat format = new DecimalFormat("#.##");


        for (int i = 0; i < n; i++) {
            String[] cmd = reader.readLine().split("\\s+");

            if (cmd[1].equals(TYPE_CAR)) {
                if (cmd[0].equals(COMMAND_DRIVE)) {
                    if (car.drive(Double.parseDouble(cmd[2]))) {
                        System.out.println("Car travelled " + format.format(Double.parseDouble(cmd[2]))
                                + " km");
                    } else {
                        System.out.println("Car needs refueling");
                    }
                } else if (cmd[0].equals(COMMAND_REFUEL)) {
                    car.refueled(Double.parseDouble(cmd[2]));
                }
            } else if (cmd[1].equals(TYPE_TRUCK)) {
                if (cmd[0].equals(COMMAND_DRIVE)) {
                    if (truck.drive(Double.parseDouble(cmd[2]))) {
                        System.out.println("Truck travelled " + format.format(Double.parseDouble(cmd[2]))
                                + " km");
                    } else {
                        System.out.println("Truck needs refueling");
                    }
                } else if (cmd[0].equals(COMMAND_REFUEL)) {
                    truck.refueled(Double.parseDouble(cmd[2]));
                }
            } else if (cmd[1].equals(TYPE_BUS)) {
                if (cmd[0].equals(COMMAND_DRIVE)) {
                    bus.setFuelConsuptionPerKm(Double.parseDouble(busTokens[2]) + BUS_EXTRA_CONSUPTION);
                    if (bus.drive(Double.parseDouble(cmd[2]))) {
                        System.out.println("Bus travelled " + format.format(Double.parseDouble(cmd[2]))
                                + " km");
                    } else {
                        System.out.println("Bus needs refueling");
                    }
                } else if (cmd[0].equals(COMMAND_DRIVE_EMPTY)) {
                    if (bus.drive(Double.parseDouble(cmd[2]))) {
                        System.out.println("Bus travelled " + format.format(Double.parseDouble(cmd[2]))
                                + " km");
                    } else {
                        System.out.println("Bus needs refueling");
                    }
                } else if (cmd[0].equals(COMMAND_REFUEL)) {
                    bus.refueled(Double.parseDouble(cmd[2]));
                }
            }

        }

        System.out.printf("Car: %.2f", car.getFuelQuantity());
        System.out.printf("\nTruck: %.2f", truck.getFuelQuantity());
        System.out.printf("\nBus: %.2f", bus.getFuelQuantity());

    }
}
