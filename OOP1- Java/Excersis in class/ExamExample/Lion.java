package fmi.uni.bachelor;

public class Lion extends Animal {

	private double roarIntensity;
	public static final int MAX_PER_CAGE = 1;	
	
	@Override
	public String printInfo() {
		return "Name: " + getName();
	}

	public Lion(double roarIntensity, String name) {
		super();
		this.roarIntensity = roarIntensity;
		setName(name);
	}
	
	

}
