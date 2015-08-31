package appPackage;

import java.util.ArrayList;

public class AssignmentOne {
	public double ArrayAverage(ArrayList<Double> list) {
		//Find total of objects in list and calculate average
		double count = 0;
		for (double i : list) {
			count += i;
		}
		
		double avg = (count / list.size());
		return avg;
	}
}
