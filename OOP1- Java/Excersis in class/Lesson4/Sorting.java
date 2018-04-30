
public class Sorting {

	public static void main(String[] args) {
		int[] numbers = {1, 55, 65, 9, 0, -5, -4, 13};
		
		for(int i = 0; i < numbers.length - 1; i++){
			
			for(int j = i + 1;j < numbers.length; j++){
				
				if(numbers[i] > numbers[j]){
					int temp = numbers[i];
					numbers[i] = numbers[j];
					numbers[j] = temp;
				}
			}
		}
		
		for(int element : numbers){
			System.out.println(element);
		}

	}

}
