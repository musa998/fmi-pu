package oop;

public class Car extends Vehicle {

    static double SUMMER_EXTRA_CONSUPTION  = 0.9;

    public Car(double fuelQuantity, double fuelConsuptionPerKm) {
        super(fuelQuantity, fuelConsuptionPerKm);
    }

    public Car(double fuelQuantity, double fuelConsuptionPerKm, double tankCapacity) {
        super(fuelQuantity, fuelConsuptionPerKm, tankCapacity);
    }

    @Override
    public void setFuelConsuptionPerKm(double fuelConsuptionPerKm) {
        super.setFuelConsuptionPerKm(fuelConsuptionPerKm + SUMMER_EXTRA_CONSUPTION) ;
    }

}