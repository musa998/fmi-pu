
public class MainClass {

	
	public static void main(String[] args) {
		
		ThreadExample t1 = new ThreadExample();
		ThreadExample t2 = new ThreadExample();
		t1.name = "t1";
		t2.name = "t2";
		t1.start();
		t2.start();
		
//		Hero h1 = new Hero("Ivancho", 1000, 1, 500, 5, 10, 10);
//		Hero h2 = new Hero("Mariika", 500, 1, 80, 500, 5, 20);
//		h1.target = h2;
//		h2.target = h1;
//		
//		h1.start();
//		h2.start();
	}

}
