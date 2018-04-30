package uni.fmi.bachelors;

public class Triangle {
	private double a;
	private double b;
	private double c;
	private double h;
	
	public double getA() {
		return a;
	}
	public void setA(double a) {
		this.a = a;
	}
	public double getB() {
		return b;
	}
	public void setB(double b) {
		this.b = b;
	}
	public double getC() {
		return c;
	}
	public void setC(double c) {
		this.c = c;
	}
	public double getH() {
		return h;
	}
	public void setH(double h) {
		this.h = h;
	}
	
	public double calculatePerimeter(){
		return a + b + c;
	}
	
	public double calculateArea(){
		return a * h / 2;
	}
	
	public void getInfo(){
		System.out.println("Триагълник със страни а = " 
				 + a + " б = " + b + " c = " + c
				 + " и лице = " + calculateArea() 
				 + " и периметър = " + calculatePerimeter());
	}
	
	public boolean isTriangle(double a, double b, double c){
		if((a + b > c) && (b + c > a) && (a + c > b)){
			return true;
		}else{
			return false;
		}
	}
	
	public Triangle(double a, double b, double c, double h) {
		
		if(isTriangle(a, b, c)){
			this.a = a;
			this.b = b;
			this.c = c;
			this.h = h;
		}else{
			System.out.println("Не може да бъде триъгъклник");
		}
	}
	
}
