package uni.fmi.bachelors;

abstract public class SeaVehicle extends Vehicle{

	private double deepLevel;
	
	public SeaVehicle(double maxSpeed, String brand, int year) {
		super(maxSpeed, brand, year);
	}
}
