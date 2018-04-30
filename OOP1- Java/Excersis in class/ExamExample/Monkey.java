package fmi.uni.bachelor;

public class Monkey extends Animal{

	private double bananas;
	public static final int MAX_PER_CAGE = 3;
	
	@Override
	public String printInfo() {
		return "Name: " + getName() + " bananas per day "
				+ bananas + " needs " + getLivingArea() 
				+ " km2";
	}

	public Monkey(double bananas, String name) {
		this.bananas = bananas;
		setName(name);
	}
}
