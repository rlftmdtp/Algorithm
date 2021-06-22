package Programmers.level2;

import java.util.*;

public class LifeBoat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int limit = 100;
		int people[] = {70, 50, 80, 50};
		System.out.println(solution(people, limit));
	}
	
	 public static int solution(int[] people, int limit) {
	        Arrays.sort(people);
	        
	        int boat = 0;
	        int min = 0;
	        for(int max=people.length-1; min<=max; max--) {
	        	if(people[max] + people[min] <= limit) min++;

	        	boat ++;
	        }
	       
	        return boat;
	    }
	

}
