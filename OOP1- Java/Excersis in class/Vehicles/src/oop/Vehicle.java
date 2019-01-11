package oop;

public abstract class  Vehicle {

    private double fuelQuantity;
    private   double fuelConsuptionPerKm;
    private double drivenDistance;
    private   double liters;
    private double tankCapacity;


    public Vehicle(double fuelQuantity, double fuelConsuptionPerKm) {
        setFuelQuantity(fuelQuantity);
        setFuelConsuptionPerKm(fuelConsuptionPerKm);
    }

    public Vehicle(double fuelQuantity, double fuelConsuptionPerKm, double tankCapacity) {
        setFuelQuantity(fuelQuantity);
        setFuelConsuptionPerKm(fuelConsuptionPerKm);
        setTankCapacity(tankCapacity);
    }

    public  boolean drive(double distance){
        double neededFuel = distance * this.fuelConsuptionPerKm;
        if (getFuelQuantity() > neededFuel){
            this.fuelQuantity -= neededFuel;
            return true;
        }
        return false;
    }

    public  void refueled(double liters){
        // TODO

        if ((liters + this.fuelQuantity) > this.tankCapacity){
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
        else if (liters <= 0){
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        else {
            this.fuelQuantity += liters;
        }
    }

    public double getTankCapacity() {
        return tankCapacity;
    }

    public void setTankCapacity(double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }
    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public void setFuelQuantity(double fuelQuantity) {
        if (fuelQuantity <= 0){
            throw new IllegalArgumentException("Fuel must be a positive number");
            ///System.out.println("Fuel must be a positive number");
        }
        this.fuelQuantity = fuelQuantity;
    }

    public double getFuelConsuptionPerKm() {
        return fuelConsuptionPerKm;
    }

    public void setFuelConsuptionPerKm(double fuelConsuptionPerKm) {
            this.fuelConsuptionPerKm = fuelConsuptionPerKm;
    }

    public double getDrivenDistance() {
        return drivenDistance;
    }

    public void setDrivenDistance(double drivenDistance) {
        this.drivenDistance = drivenDistance;
    }

    public double getLiters() {
        return liters;
    }

    public void setLiters(double liters) {
        this.liters = liters;
    }
}
