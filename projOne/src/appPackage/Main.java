package appPackage;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {	
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
		
		System.out.println("Average of values: " + findAvg.ArrayAverage(list));
		
		//Collections API used to find max and min values
		System.out.println("Largest value: " + Collections.max(list));
		System.out.println("Smallest value: " + Collections.min(list));
		
		//Collections API used to sort list in ascending order
		Collections.sort(list);
		System.out.println("\nValues in ascending order: " + list);
		
		s.close();
	}
}
