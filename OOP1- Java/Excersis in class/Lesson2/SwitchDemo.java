package uni.fmi.bachelors;

import java.util.Scanner;

public class SwitchDemo {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Кой ден сме?");
		
		String day = keyboard.next();
		
		switch(day){
		case "pon":
		case "vto":
		case "srq":
		case "chet":
			System.out.println("Работен ден!");
			break;
		case "pet":
			System.out.println("Работен ден за уиски!");
			break;
		case "sab": case "ned":
			System.out.println("Почивен ден!");
			default:
				System.out.println("Неразпознат ден!");
		}
	}

}
