package fmi.uni.bachelor;

public abstract class Animal {

	private String name;
	private static double livingArea;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public static double getLivingArea() {
		return livingArea;
	}
	public static void setLivingArea(double livingArea) {
		Animal.livingArea = livingArea;
	}
	
	public abstract String printInfo();
	
}
