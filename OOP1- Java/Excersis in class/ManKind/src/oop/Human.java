package oop;

public class Human {

    private String firstName;
    private String lastName;

    public Human(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {

        return firstName;
    }

    public void setFirstName(String firstName) throws IllegalAccessException {

        //Character.isUpperCase(s.charAt(0))
        if (Character.isUpperCase(firstName.charAt(0)) == false){
            throw new IllegalAccessException("Expected upper case letter!Argument: firstName");
        }
        if (firstName.length() < 4){
            throw new IllegalAccessException("Expected length at least 4 symbols!Argument: firstName");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) throws IllegalAccessException {
        if (Character.isUpperCase(firstName.charAt(0)) == false){
            throw new IllegalAccessException("Expected upper case letter!Argument: lastName");
        }
        if (firstName.length() < 3){
            throw new IllegalAccessException("Expected length at least 3 symbols!Argument: firstName");
        }
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "First Name: " + getFirstName()+
                "\nLast Name: " + getLastName();
    }
}
