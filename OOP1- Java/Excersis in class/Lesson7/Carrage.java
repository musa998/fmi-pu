package uni.fmi.bachelors;

public class Carrage extends Vehicle {

	public Carrage(double maxSpeed, String brand, int year) {
		super(maxSpeed, brand, year);
	}

	@Override
	public String sound() {
		return "Mahni se ot patqqqqqqq!";
	}

	@Override
	public double realSpeed(double kw, double resistence) {
		return kw/resistence;
	}

}
