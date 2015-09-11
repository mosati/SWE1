package appPackage;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.io.File;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {	
		
		//EventQueue.invokeLater(new Runnable() {
		//	public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
		//	}
		//});
		
		AssignmentOne findAvg = new AssignmentOne();
		
		//Read in numbers from text file
		Scanner s = new Scanner(new File("src/input.txt"));
		ArrayList<Double> list = new ArrayList<Double>();
		
		//Add numbers to array list
		try {
			while (s.hasNext()) {
				if(s.hasNextDouble()) {
					list.add(s.nextDouble());
				}
				else {
					s.next();
				}
			}
		} catch (InputMismatchException e) {
			System.err.println("Caught exception: " + e.getMessage());
		}
		
		//Assignment one
		//Use AssignmentOne class to calculate average
		System.out.println("Average of values: " + findAvg.ArrayAverage(list));
		
		//Modified assignment one
		//Collections API used to find max and min values
		System.out.println("Largest value: " + Collections.max(list));
		System.out.println("Smallest value: " + Collections.min(list));
		
		//Assignment two
		//Collections API used to sort list in ascending order
		Collections.sort(list);
		System.out.println("\nValues in ascending order: " + list);
		
		s.close();
	}
}
