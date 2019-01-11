package oop;

public class Chicken {

    private String name;
    private int age;
    private double produckPerDay;

    public double getProduckPerDay() {
        return calculateProductPerDay();
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Chicken(String name, int age) {
        this.name = name;
        this.age = age;
    }
    private double calculateProductPerDay(){
        if (age > 0 && age <= 5) return 2;
        if (age >5 && age <= 11) return  1;
        if (age > 11 && age <= 15) return  0.75;
        else return 0;
    }
}
