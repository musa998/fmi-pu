package oop;

public class Mouse extends Mammal {
    public Mouse(String name, String type, double weight,String livingRegion) {
        super(name, type, weight, livingRegion);
    }

    @Override
    public void eat(Food food) {
        if (food.getClass().getSimpleName().equals("Vegetable")){
            super.foodEaten += food.quantity;
        }
        else {
            System.out.println(super.type  + super.DIFFERENT_TYPE_FOOD);
        }
    }
    @Override
    public void makeSound() {
        System.out.println("SQUEEEAAAK!");
    }
}
