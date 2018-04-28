package view;

import java.util.Scanner;

import model.AnimalFactory;

public class App {
	
	public static void main(String[] args) {
		
		Scanner S0 = new Scanner(System.in);
		int choice = 1;
	
		AnimalFactory zoo = AnimalFactory.getInstance();
		zoo.serveList();
		System.out.println("Enter entry no. for details (or 0 for exit):");
		zoo.separate(0);
		while (choice != 0) {
			choice = S0.nextInt();
			zoo.separate(0);
			if (choice != 0) {
				zoo.serveDetails(choice);
				System.out.println("Enter entry no. for details (or 0 for exit):");
				zoo.separate(1);
			} else {
				System.out.println("Thank you for visiting, come again!");
				zoo.separate(0);
			}
		}
		S0.close();			    
	}

}
