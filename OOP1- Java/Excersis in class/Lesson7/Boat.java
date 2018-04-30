package uni.fmi.bachelors;

public class Boat extends SeaVehicle{

	public Boat(double maxSpeed, String brand, int year) {
		super(maxSpeed, brand, year);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String sound() {
		// TODO Auto-generated method stub
		return null; 
	}

	@Override
	public double realSpeed(double kw, double resistence) {
		// TODO Auto-generated method stub
		return 0;
	}

}
