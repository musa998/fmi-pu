package uni.fmi.bachelors;

public class Airplane extends Vehicle{
	
	public Airplane(double maxSpeed, String brand, int year) {
		super(maxSpeed, brand, year);
	}

	@Override
	public String sound() {
		return "Attention all passagers!";
	}

	@Override
	public double realSpeed(double kw, double resistence) {
		return (kw * getMaxSpeed()) / resistence;
	}

}
