package oop;

public class Tiger extends Feline {

    String livingRegion;

    public Tiger(String name, String type, double weight, String livingRegion) {
        super(name, type, weight, livingRegion);
    }

    @Override
    public void eat(Food food) {
        if (food.getClass().getSimpleName().equals("Meat")){
            super.foodEaten += food.quantity;
        }
        else {
            System.out.println(super.type +"s" + super.DIFFERENT_TYPE_FOOD);
        }
    }

    @Override
    public void makeSound() {
        System.out.println("ROAAR!!!");
    }
}
