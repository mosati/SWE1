package appPackage;

import java.util.List;

public class AssignmentOne {
	public double ArrayAverage(List<Double> list) {
		//Find total of objects in list and calculate average
		double count = 0;
		for (double i : list) {
			count += i;
		}
		
		double avg = (count / list.size());
		return avg;
	}
}
