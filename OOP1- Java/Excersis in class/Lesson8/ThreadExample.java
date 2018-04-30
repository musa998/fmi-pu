
public class ThreadExample extends Thread{

	String name;
	static int number = 0;
	static MainClass lock = new MainClass();

	@Override
	public void run() {
		
			for(; number < 1000; number++){
				synchronized (lock) {
					System.out.println(name + ":" + number);
				}
			}
	
	}
	
	

}
