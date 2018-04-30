package uni.fmi.bachelors;

import java.util.ArrayList;

public class MainClass {

	public static void main(String[] args) {
		Rectangle r1 = new Rectangle(2, 3);
		Rectangle r2 = new Rectangle(6, 2);
		
		Trapez t1 = new Trapez(5, 2, 1, 66, 2);
		Trapez t2 = new Trapez(7, 5, 2, 3, 21);
		
		Triangle tr1 = new Triangle(4, 2, 5, 2);
		Triangle tr2 = new Triangle(8, 1, 2, 1);
		
		ArrayList<Shape> figures = new ArrayList<>();
		
		figures.add(r1);
		figures.add(r2);
		figures.add(t1);
		figures.add(t2);
		figures.add(tr1);
		figures.add(tr2);
		
		for(Shape s : figures){
			if(s instanceof Rectangle){
				System.out.println(s.calculateArea());
			}else if(s.getClass().getSimpleName().equals("Trapez")){
				System.out.println(s.calculatePerimeter());
			}
			
		}
	}

}
