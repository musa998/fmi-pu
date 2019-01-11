package oop;

public class Truck extends Vehicle {

    static double SUMMER_EXTRA_CONSUPTION  = 1.6;

    public Truck(double fuelQuantity, double fuelConsuptionPerKm) {
        super(fuelQuantity, fuelConsuptionPerKm);
    }

    public Truck(double fuelQuantity, double fuelConsuptionPerKm, double tankCapacity) {
        super(fuelQuantity, fuelConsuptionPerKm, tankCapacity);
    }

    @Override
    public void setFuelConsuptionPerKm(double fuelConsuptionPerKm) {
        super.setFuelConsuptionPerKm(fuelConsuptionPerKm + SUMMER_EXTRA_CONSUPTION);
    }

    @Override
    public void refueled(double liters) {
        double realLitersRefueled  = (liters * 95) / 100;
        super.refueled(realLitersRefueled);
    }
}
