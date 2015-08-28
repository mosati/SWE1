package appPackage;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		
		//Read in numbers from text file
		Scanner s = new Scanner(new File("src/input.txt"));
		ArrayList<Double> list = new ArrayList<Double>();
		
		//Add numbers to array list
		while (s.hasNext()) {
			list.add(s.nextDouble());
		}
		
		//Find total of objects in list and calculate average
		double count = 0;
		for (double i : list) {
			count += i;
		}
		
		double avg = (count / list.size());
		System.out.println("Average of values: " + avg);
		
		//Collections API used to find max and min values
		System.out.println("\nLargest value: " + Collections.max(list));
		System.out.println("Smallest value: " + Collections.min(list));
		
		//Collections API used to sort list in ascending order
		Collections.sort(list);
		System.out.println("\nValues in ascending order: " + list);
		
		s.close();
	}
}
