package uni.fmi.bachelors;

import java.util.Scanner;

public class SquareRootProblem {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.println("Моля веъведете а,б и с");

		double a = input.nextDouble();
		double b = input.nextDouble();
		double c = input.nextDouble();

		double d = b * b - 4 * a * c;
		
		if(d > 0 ){
			double x1 = (-b + Math.sqrt(d)) / 2 * a;
			double x2 = (-b - Math.sqrt(d)) / 2 * a;
			
			System.out.println("X1 = " + x1 +
					" X2 = " + x2);
		}else if(d == 0){
			double x1 =  -b / 2 * a;
			System.out.println("X1,2 = " + x1);
		}else{
			System.out.println("няма реални корени");
		}

	}

}
