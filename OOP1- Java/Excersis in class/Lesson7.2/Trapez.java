package uni.fmi.bachelors;

public class Trapez implements Shape{

	double a;
	double b;
	double c;
	double d;
	double h;
		
	public Trapez(double a, double b, double c, double d, double h) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		this.h = h;
	}

	@Override
	public double calculateArea() {
		return (a+b) * h / 2;
	}

	@Override
	public double calculatePerimeter() {
		return a + b + c + d;
	}

}
