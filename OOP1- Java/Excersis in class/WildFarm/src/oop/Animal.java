package oop;

public abstract class Animal {

     static final String DIFFERENT_TYPE_FOOD = " are not eating that type of food!";

    String name;
    String type;
    double weight;
    int foodEaten;

    public Animal(String name, String type, double weight, int foodEaten) {
        this.name = name;
        this.type = type;
        this.weight = weight;
        this.foodEaten = foodEaten;
    }

    public Animal(String name, String type, double weight) {
        this.name = name;
        this.type = type;
        this.weight = weight;
    }

    public void makeSound(){

    }
    public void eat(Food food){

    }
}
