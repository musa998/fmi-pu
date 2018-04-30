package uni.fmi.bachelors;

public abstract class Vehicle {

	private double maxSpeed;
	private int year;
	private String brand;
	private String color;

	abstract public String sound();
	abstract public double realSpeed(double kw, double resistence);

	public String printInfo() {
		return "Max Speed = " + maxSpeed + " production year " + year;
	}

	public Vehicle(double maxSpeed, String brand, int year) {
		this.maxSpeed = maxSpeed;
		this.brand = brand;
		this.year = year;
	}

	public double getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(double maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}
