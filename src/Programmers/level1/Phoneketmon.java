package Programmers.level1;

import java.util.*;

public class Phoneketmon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {3,1,2,3};
		solution(nums);
	}
	
	public static int solution(int[] nums) {
		
		HashSet<Integer> hs = new HashSet<Integer>();
		for(int i=0; i<nums.length; i++) {
			hs.add(nums[i]);
		}
		
		if(hs.size() > nums.length/2) return nums.length/2;
		else return hs.size();
	}

}
