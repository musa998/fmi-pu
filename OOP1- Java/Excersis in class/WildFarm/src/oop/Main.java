package oop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        while (true){
            String[] animalToknes = reader.readLine().split(" ");
            if (animalToknes[0].equals("End")) break;
            String[] foodTokens = reader.readLine().split(" ");
            Food food = null;

            switch (animalToknes[0]){
                case "Cat":
                    Mammal cat = new Cat(animalToknes[1], animalToknes[0], Double.parseDouble(animalToknes[2]),
                            (animalToknes[3]), animalToknes[4]);
                   if (foodTokens[0].equals("Vegetable")){
                        food =  new Vegetable(Integer.parseInt(foodTokens[1]));
                   }
                   else if (foodTokens[0].equals("Meat")){
                        food = new Meat(Integer.parseInt(foodTokens[1]));
                   }
                    cat.makeSound();
                    cat.eat(food);
                    System.out.println(cat.toString());
                    break;
                case "Tiger":
                    Animal tiger  = new Tiger(animalToknes[1], animalToknes[0],
                            Double.parseDouble(animalToknes[2]), (animalToknes[3]));
                    if (foodTokens[0].equals("Vegetable")){
                         food =  new Vegetable(Integer.parseInt(foodTokens[1]));
                    }
                    else if (foodTokens[0].equals("Meat")){
                        food = new Meat(Integer.parseInt(foodTokens[1]));
                    }
                    tiger.makeSound();
                    tiger.eat(food);
                    System.out.println(tiger.toString());
                    break;
                case "Zebra":
                    Animal zebra = new Zebra(animalToknes[1], animalToknes[0],
                            Double.parseDouble(animalToknes[2]), (animalToknes[3]));
                    if (foodTokens[0].equals("Vegetable")){
                         food =  new Vegetable(Integer.parseInt(foodTokens[1]));
                    }
                    else if (foodTokens[0].equals("Meat")){
                         food = new Meat(Integer.parseInt(foodTokens[1]));
                    }
                    zebra.makeSound();
                    zebra.eat(food);
                    System.out.println(zebra.toString());
                    break;
                case "Mouse":
                    Animal mouse = new Mouse(animalToknes[1], animalToknes[0],
                            Double.parseDouble(animalToknes[2]), (animalToknes[3]));
                    if (foodTokens[0].equals("Vegetable")){
                         food =  new Vegetable(Integer.parseInt(foodTokens[1]));
                    }
                    else if (foodTokens[0].equals("Meat")){
                         food = new Meat(Integer.parseInt(foodTokens[1]));
                    }
                    mouse.makeSound();
                    mouse.eat(food);
                    System.out.println(mouse.toString());
                    break;
            }

        }
        //System.out.println("End");


    }
}
