package com.mycompany.hashcode;

public class Main {

	public static void main(String[] args) {
		// We're going to launch every test as an object
		
		System.out.println("Starting program...");
		
		Principal a = new Principal("a_example.txt", "A");
		Principal b = new Principal("b_read_on.txt", "B");
		Principal c = new Principal("c_incunabula.txt", "C");
		Principal d = new Principal("d_tough_choices.txt", "D");
		Principal e = new Principal("e_so_many_books.txt", "E");
		Principal f = new Principal("f_libraries_of_the_world.txt", "F");
		
		System.out.println("Launching threads...");
		
		a.start();
		//b.start();
		//c.start();
		//d.start();
		//e.start();
		f.start();
		
	}

}
