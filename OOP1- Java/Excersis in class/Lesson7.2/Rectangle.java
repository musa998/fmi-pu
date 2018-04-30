package uni.fmi.bachelors;

public class Rectangle implements Shape{

	double a;
	double b;
	
	public Rectangle(double a, double b) {
		this.a = a;
		this.b = b;
	}	
	
	@Override
	public double calculateArea() {
		return b*a;
	}

	@Override
	public double calculatePerimeter() {
		return 2*a + 2*b;
	}

}
