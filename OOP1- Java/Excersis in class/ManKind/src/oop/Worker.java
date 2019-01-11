package oop;

import java.text.DecimalFormat;

public class Worker extends Human {

    private double salary;
    private double hoursPerDay;


    public Worker(String firstName, String lastName, double salary, double hoursPerDay) throws IllegalAccessException {
        super(firstName, lastName);
        this.setSalary(salary);
       this.setHoursPerDay(hoursPerDay);
    }

    public double getSalary() {
        double  value = Double.parseDouble(new DecimalFormat("##.##")
                .format(salary));

        return value;
    }

    public void setSalary(double salary) throws IllegalAccessException {
        if (salary < 10){
            throw new IllegalAccessException("Expected value mismatch!Argument: weekSalary");
        }
        this.salary = salary;
    }

    public double getHoursPerDay() {
        double  value = Double.parseDouble(new DecimalFormat("##.##")
                .format(hoursPerDay));

        return value;
    }

    @Override
    public void setLastName(String lastName) throws IllegalAccessException {
        if (lastName.length() < 3){
            throw new IllegalAccessException("Expected length more than 3 symbols!Argument: lastName");
        }
        super.setLastName(lastName);
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nWeek Salary: " + getSalary() +
                "\nHours per day: " + getHoursPerDay() +
                "\nSalary per hour: " + getSalaryperHour();
    }
    public Double getSalaryperHour(){
       double  value = Double.parseDouble(new DecimalFormat("##.##")
               .format((getSalary() / 7) / getHoursPerDay()));

        return value ;
    }

    public void setHoursPerDay(double hoursPerDay) throws IllegalAccessException {
        if (hoursPerDay < 1 || hoursPerDay > 12){
            throw  new IllegalAccessException("Expected value mismatch!Argument: workHoursPerDay");
        }
        this.hoursPerDay = hoursPerDay;
    }
}
