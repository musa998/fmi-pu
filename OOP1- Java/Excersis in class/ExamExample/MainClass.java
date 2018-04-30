package fmi.uni.bachelor;

import java.util.ArrayList;

public class MainClass {

	public static void main(String[] args) {
		Monkey m1 = new Monkey(1, "Pesho");
		Monkey m2 = new Monkey(5, "Danka");
		Monkey m3 = new Monkey(33, "Penka");
		
		Lion l1 = new Lion(955, "Lavcho");
		Lion l2 = new Lion(74, "Kotio");
		
		ArrayList<Animal> animals = new ArrayList<>();
		
		animals.add(m1);
		animals.add(m2);
		animals.add(m3);
		animals.add(l1);
		animals.add(l2);		

		double lionArea = 0;
		double lions = 0;
		double monkeyArea = 0;
		double monkeys = 0;
		
		for(Animal an : animals){
			an.printInfo();
			
			if(an instanceof Lion){
				lions++;
				lionArea += an.getLivingArea();
			}else if(an.getClass().getSimpleName().equals("Monkey")){
				monkeyArea++;
				monkeyArea += an.getLivingArea();
			}
		}
		
		int monkeysCages = 0;
		
		if( monkeys % Monkey.MAX_PER_CAGE == 0){
			monkeysCages = (int)monkeys / Monkey.MAX_PER_CAGE;
		}else{
			monkeysCages = (int)monkeys / Monkey.MAX_PER_CAGE + 1;
		}
		
		int lionCages = 0;
		
		if( monkeys % Lion.MAX_PER_CAGE == 0){
			lionCages = (int)lions / Lion.MAX_PER_CAGE;
		}else{
			lionCages = (int)lions / Lion.MAX_PER_CAGE + 1;
		}	 
		
		System.out.println("Zoo is "  + (lionArea + monkeyArea));
		System.out.println("Number of monkey cages is : "
				+ monkeysCages);
		
		System.out.println("Number of lions cages is : "
				+ lionCages);
		
	}

}
