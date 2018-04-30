package uni.fmi.bachelors;

public class Person {
	private int age;
	private String name;
	private String EGN;
	private String gender;
	
	public Person(String EGN, String name){
		this.EGN = EGN;
		this.name = name;
	}	
	
	public String printInfo(){
		return "Name: " + name + " age " + age;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEGN() {
		return EGN;
	}
	public void setEGN(String eGN) {
		EGN = eGN;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}		
	
	@Override
	public String toString() {
		return "Name = " + getName()
		 + " age = " + getAge()
		 + " gender = " + getGender()
		 + " EGN = " + getEGN();
	}
	
}
