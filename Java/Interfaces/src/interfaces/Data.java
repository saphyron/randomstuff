package interfaces;

public class Data {
	
	public static Measurable max(Measurable[] objects) {
		Measurable highestMeasurebleSoFar = objects[0];
		for (Measurable m : objects) {
			if(m.getMeasure() > highestMeasurebleSoFar.getMeasure()) {
				highestMeasurebleSoFar = m;
			}
		}
		return highestMeasurebleSoFar;
	}
	
	public static double avg(Measurable[] objects) {
		double avg = 0;
		int counter = 0;
		for (Measurable m : objects) {
			counter++;
			avg += m.getMeasure();
		}
		return avg / counter;
	}

}
