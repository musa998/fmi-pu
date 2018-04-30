package uni.fmi.bachelors;

import java.util.Scanner;

public class IfElseDemo {

	public static void main(String[] args) {
		Scanner in =  new Scanner(System.in);
		
		System.out.println("Моля въведете итнервал");
		
		double from  = in.nextDouble();
		double to = in.nextDouble();
		
		System.out.println("Моля въведе число");
		
		double number = in.nextDouble();
		
		if(number >= from && number <= to){
			System.out.println("Намирасе вътре");
		}else{
			System.out.println("Извън интервала");
		}
		
		
		
	}

}
