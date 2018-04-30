package uni.fmi.bachelors;

import java.util.ArrayList;

public class Student extends Person{
	
	private String fakNumber;
	private int year;
	private boolean isRegular;
	private ArrayList<Subject> grades = new ArrayList<>();
	
	public void addGrade(Subject sub){
		grades.add(sub);
	}
	
	public String showAllGrades(){
		String result = "";
		
		for(Subject grade : grades){
			result += grade.getName() + " " + grade.getGrade() + "\n"; 
		}
		
		return result;
	}
	
	public Student(String name, String EGN, String fakNumber){
		super(name, EGN);
		this.fakNumber = fakNumber;
	}
	
	@Override
	public String printInfo(){
		return "Name = " + getName() + " fakNumber = " + fakNumber
				+ "\n" + showAllGrades() ;
	}
	
	@Override
	public String toString() {
		return "Original = " + super.toString() + 
				
				" Student Fakulteten nomer =" + fakNumber + ", year=" + year + ", isRegular=" + isRegular + ", getAge()="
				+ getAge() + ", getName()=" + getName() + ", getEGN()=" + getEGN() + ", getGender()=" + getGender()
				+ "]";
	}	
}
