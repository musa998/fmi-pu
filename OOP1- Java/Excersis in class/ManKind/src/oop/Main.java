package oop;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IllegalAccessException {
        Scanner scanner = new Scanner(System.in);


        String[] studentInfo = scanner.nextLine().split(" ");
        String[] workerInfo = scanner.nextLine().split(" ");

        Student student = new Student(studentInfo[0], studentInfo[1], studentInfo[2]);
        Worker worker = new Worker(workerInfo[0], workerInfo[1], Double.parseDouble(workerInfo[2]),
                Double.parseDouble(workerInfo[3]));

        System.out.println(student.toString());
        System.out.println();
        System.out.println(worker.toString());



    }
}
