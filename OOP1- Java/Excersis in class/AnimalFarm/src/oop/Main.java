package oop;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String name;
        int age;


            name = scanner.nextLine();
            age = scanner.nextInt();

        while (name.length()  < 0 || name.equals(null) || name.trim().length() < 0 || age < 0 || age > 15){
            System.out.println("Age should be between 0 and 15.");
            return;
        }
      //  DecimalFormat format = new DecimalFormat("0");
        Chicken chicken = new Chicken(name, age);
        System.out.println("Chicken " + chicken.getName() + "(age "+(int)(chicken.getAge())+
                ") can produce "+(chicken.getProduckPerDay())+ " eggs per day.");

    }
}
