package oop;

public class Cat extends Feline {

    String breed;

    public Cat(String name, String type, double weight, String livingRegion, String breed) {
        super(name, type, weight, livingRegion);
        this.breed = breed;
    }

    @Override
    public String toString() {
      return Cat.class.getSimpleName().toString() + "[" + super.name +", " + this.breed +  ", " + super.weight + ", "
                + this.livingRegion + ", " + super.foodEaten +"]";
    }

    @Override
    public void eat(Food food) {
        super.foodEaten += food.quantity;
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }
}
