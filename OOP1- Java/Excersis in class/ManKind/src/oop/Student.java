package oop;

public class Student extends Human{

   private String facultyNumber;


    public Student(String firstName, String lastName, String facultyNumber) throws IllegalAccessException {
        super(firstName, lastName);
        this.setFacultyNumber(facultyNumber);
    }


    @Override
    public String toString() {
        return super.toString()+
                "\nFaculty Number: " + getFacultyNumber();
    }

    public String getFacultyNumber() {
        return facultyNumber;
    }

    public void setFacultyNumber(String facultyNumber) throws IllegalAccessException {
        if (facultyNumber.length() < 5 || facultyNumber.length() > 10){
            throw new IllegalAccessException("Invalid faculty number!");
        }
        this.facultyNumber = facultyNumber;
    }
}

