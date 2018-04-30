
public class ForExample {

	public static void main(String[] args) {
		for(int i = 2 ; i < 10000000; i++){
			boolean isPrime = true;
			
			for(int j  = 2; j < i/2 + 1 ; j++){
				
				if(i % j == 0){
					isPrime = false;
					break;
				}
			}
			
			if(isPrime)
				System.out.println(i);
		}
	}

}
