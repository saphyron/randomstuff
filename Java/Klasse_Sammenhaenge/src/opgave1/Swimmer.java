package opgave1;

import java.util.*;

/**
 * Modeling a Swimmer
 */
public class Swimmer {
    private String name;
    private String club;
    private int yearGroup;
    private ArrayList<Double> lapTimes;
    private TrainingPlan plan;
    
    /**
     * Initialize a new swimmer with name, club, yearGroup, and lap times.
     */ 

   public Swimmer(String name, int yearGroup, ArrayList<Double> lapTimes, String club, TrainingPlan trainingPlan) {
       this.name = name;
       this.yearGroup = yearGroup;
       this.lapTimes = lapTimes;
       this.club = club;
       this.plan = trainingPlan;
   }
    /**
     * Return the name of the swimmer
     */
    public String getName() {
        return this.name;
    }

    /**
     * Return the yearGroup of the swimmer
     */
    public int getYearGroup() {
        return this.yearGroup;
    }

    /**
     * Return the club of the swimmer
     */
    public String getClub() {
        return this.club;
    }

    /**
     * Register the club of the swimmer
     * @param club
     */
    public void setClub(String club) {
        this.club = club;
    }
    
    /**
     * Return the fastest lap time
     */
    public double bestLapTime() {
        double bestTime = Integer.MAX_VALUE;
        for (int i = 0; i < lapTimes.size(); i++) {
        	if (bestTime > lapTimes.get(i)) {
        		bestTime = lapTimes.get(i);
        	}
        }
        return bestTime;
    }
    
    /**
    * Return how many training hours the swimmer has each week.
    */
    public int allTrainingHours() {
    	int trainingHours = 0;
    	if(plan.getWeeklyStrengthHours() > 0 && plan.getWeeklyWaterHours() > 0) {
    		trainingHours = plan.getWeeklyWaterHours() + plan.getWeeklyStrengthHours();
    	}
    	return trainingHours;
    }
}
