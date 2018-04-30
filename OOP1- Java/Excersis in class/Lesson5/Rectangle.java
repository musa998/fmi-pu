package uni.fmi.bachelors;

import java.util.Scanner;

public class Rectangle {
	private double a;
	private double b;
	
	Scanner s = new Scanner(System.in);
	
	public double calculateArea(){
		return a * b;
	}
	
	public double calculatePerimeter(){
		return a*2+b*2;
	}
	
	public void setA(double a){
		if(a <= 0){
			System.out.println("Wrong measure!");
		}else{
			this.a = a;
		}		
	}
	
	public double getA(){
		return a;
	}

	public double getB() {
		return b;
	}

	public void setB(double b) {
		if( b <= 0){
			System.out.println("Wrong Measure!");
		}else{
			this.b = b;
		}
	}
	
	public Rectangle(double a, double b){
		setA(a);
		setB(b);
	}
	
	public Rectangle(double a){
		setA(a);
		setB(a);
	}

}
