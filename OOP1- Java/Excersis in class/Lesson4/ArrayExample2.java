import java.util.Scanner;

public class ArrayExample2 {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		int n = kb.nextInt();
		
		int[] numbers = new int[n];
		
		for(int i = 0; i < n; i++){
			System.out.println("Моля въведе " + (i+1));
			numbers[i] = kb.nextInt();
		}
		
		for(int i = 0 ; i < numbers.length; i++){
			System.out.print(numbers[i] + ",");
		}
	}
}
