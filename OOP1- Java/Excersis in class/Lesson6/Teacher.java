package uni.fmi.bachelors;

public class Teacher extends Person{

	private double payPerHour;
	private String degree;
	
	public Teacher(String EGN, String name, double payment) {
		super(EGN, name);
		payPerHour = payment;
	}
	
	public double calculatePayment(){
		return 40 * payPerHour * 4;
	}

	@Override
	public String printInfo(){
		return "Name = " + getName() + " payment = " + calculatePayment();
	}
}
