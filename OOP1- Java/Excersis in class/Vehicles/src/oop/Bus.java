package oop;

public class Bus extends Vehicle {
 //   static double PASSENGERS_EXTRA_CONSUPTION  = 1.4;

    //private double normalCons;

    public Bus(double fuelQuantity, double fuelConsuptionPerKm) {
        super(fuelQuantity, fuelConsuptionPerKm);
    }

    public Bus(double fuelQuantity, double fuelConsuptionPerKm, double tankCapacity) {
        super(fuelQuantity, fuelConsuptionPerKm, tankCapacity);
    }

    @Override
    public void setFuelConsuptionPerKm(double fuelConsuptionPerKm) {
        //normalCons = fuelConsuptionPerKm;
        super.setFuelConsuptionPerKm(fuelConsuptionPerKm) ;
    }
}
