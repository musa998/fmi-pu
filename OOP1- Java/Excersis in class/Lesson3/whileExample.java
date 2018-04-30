import java.util.Scanner;

public class whileExample {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
	
		int n;
	
		do{
			System.out.println("Моля въведете число м/у 1 и 100");
			n = kb.nextInt();
		}while(n < 1 || n > 100);
	}

}
