package uni.fmi.bachelors;

import java.util.ArrayList;

public class MainClass {

	public static void main(String[] args) {
		Student s1 = new Student("Goshko", "312323546", "151512334");
		Teacher t1 = new Teacher("1233424", "Vanko", 4.2);
		Person p1 = new Person("2343", "Tania");
		
		Subject sub1 = new Subject("OOP" , 6);
		s1.addGrade(sub1);
		s1.addGrade(new Subject("Matematika", 3));
		
		ArrayList<Person> list = new ArrayList<>();
		
		list.add(s1);
		list.add(t1);
		list.add(p1);
		
		for(Person o : list){
			System.out.println(o.printInfo());
		}
		
	}

}
