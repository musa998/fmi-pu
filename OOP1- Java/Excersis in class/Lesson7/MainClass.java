package uni.fmi.bachelors;

import java.util.ArrayList;

public class MainClass {

	public static void main(String[] args) {
		Airplane e = new Airplane(850, "Djumbo Djet", 1975);
		Carrage c = new Carrage(13, "Kucha", 1935);
		
		ArrayList<Vehicle> vehicles = new ArrayList<>();
		
		vehicles.add(e);
		vehicles.add(c);
		
		for(Vehicle v : vehicles){
			System.out.println(v.realSpeed(2000, 250));
			System.out.println(v.printInfo());
			System.out.println(v.sound());
		}
		


	}

}
