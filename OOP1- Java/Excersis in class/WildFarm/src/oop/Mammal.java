package oop;

import java.text.DecimalFormat;

public abstract class Mammal extends Animal {

    String livingRegion;
    DecimalFormat format = new DecimalFormat("#.##");

    public Mammal(String name, String type, double weight) {
        super(name, type, weight);
    }
    public Mammal(String name, String type, double weight, String livingRegion) {
        super(name, type, weight);
        this.livingRegion = livingRegion;
    }

    @Override
    public String toString() {
        return super.type + "[" + super.name + ", " + format.format(super.weight)+ ", "
                + this.livingRegion + ", " + super.foodEaten + "]";
    }

}
